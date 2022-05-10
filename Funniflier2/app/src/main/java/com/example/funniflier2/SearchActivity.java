package com.example.funniflier2;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import com.example.funniflier2.db.Business;
import com.example.funniflier2.db.DB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.funniflier2.ui.search.SectionsPagerAdapter;
import com.example.funniflier2.databinding.ActivitySearchBinding;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;
    SearchActivity context = this;
    public String query;
    public long user_id;
    public List<Business> businesses = new ArrayList<Business>();

    DB db = DB.getInstance(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        query = intent.getStringExtra("query");
        user_id = intent.getExtras().getLong("user_id");

        if (query.toLowerCase().contains("restaurant")){
            businesses = db.businessDao().Search(query, 0);
        } else if (query.toLowerCase().contains("hair")){
            businesses = db.businessDao().Search(query, 1);
        } else {
            businesses = db.businessDao().Search(query);
        }

        Toast.makeText(this, query + Integer.toString(businesses.size()), Toast.LENGTH_LONG).show();

        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);

        MenuItem menuItem = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Intent intent2 = new Intent(context, SearchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("query", s);
                bundle.putLong("user_id", user_id);
                intent2.putExtras(bundle);
                startActivity(intent2);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            goToSearch(item);
            return true;
        } else if (item.getItemId() == R.id.action_about) {
            Toast.makeText(context, "Done by CM, MN, JP", Toast.LENGTH_LONG).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void goToSettings(MenuItem item){
        Intent intent2 = new Intent(this, SettingsActivity.class);
        Bundle bundle = new Bundle();
        intent2.putExtras(bundle);
        this.startActivity(intent2);
    }

    public void goToSearch(MenuItem item){
        Intent intent2 = new Intent(this, SearchActivity.class);
        Bundle bundle = new Bundle();
        bundle.putLong("user_id", user_id);
        intent2.putExtras(bundle);
        this.startActivity(intent2);
    }
}