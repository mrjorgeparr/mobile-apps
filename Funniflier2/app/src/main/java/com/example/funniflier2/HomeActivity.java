package com.example.funniflier2;

import android.graphics.Color;
import android.os.Bundle;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;


import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

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
        log="hola";
        //Toast.makeText(this, log, Toast.LENGTH_LONG).show();

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Toolbar


        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            Log.d(this.getLocalClassName(), "TODO: Implement search");
            return true;
        } else if (item.getItemId() == R.id.action_settings) {
            Log.d(this.getLocalClassName(), "TODO: Implement settings");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}




