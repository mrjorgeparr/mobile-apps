package com.example.funniflier2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import com.example.funniflier2.db.Business;
import com.example.funniflier2.db.Reservation;
import com.example.funniflier2.db.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;
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

import com.example.funniflier2.db.DB;

public class HomeBusinessActivity extends AppCompatActivity{
    private ActivityHomeBinding binding;
    String log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}