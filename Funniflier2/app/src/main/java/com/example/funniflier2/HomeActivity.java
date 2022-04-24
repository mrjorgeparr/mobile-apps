package com.example.funniflier2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;


import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.funniflier2.ui.home.SectionsPagerAdapter;
import com.example.funniflier2.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity{
    private ActivityHomeBinding binding;
    String log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Toast.makeText(this, toolbar.toString(), Toast.LENGTH_LONG).show();
        //db = new DataBase();
        //log = db.createTable();

        //Toast.makeText(this, log, Toast.LENGTH_LONG).show();

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
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

                goToSearch(menuItem);
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
        } else if (item.getItemId() == R.id.action_settings) {
            Log.d(this.getLocalClassName(), "TODO: Implement settings");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    //Pop up menu from https://www.tutlane.com/tutorial/android/android-popup-menu-with-examples
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_home, popup.getMenu());
        popup.show();
    }

    public void popUpMenuClickListener(MenuItem item) {
        if (item.getItemId() == R.id.businessPopUpItem){
            Intent intent2 = new Intent(this, ScannerActivity.class);
            Bundle bundle = new Bundle();
            intent2.putExtras(bundle);
            this.startActivity(intent2);
        }else if (item.getTitle() == "Reservation"){
            Toast.makeText(this, "not available yet", Toast.LENGTH_SHORT).show();
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
        intent2.putExtras(bundle);
        this.startActivity(intent2);
    }
}