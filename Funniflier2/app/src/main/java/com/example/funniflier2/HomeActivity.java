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

public class HomeActivity extends AppCompatActivity{
    private ActivityHomeBinding binding;
    public long user_id;
    String log;
    public HomeActivity context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extra = getIntent().getExtras();
        user_id = extra.getLong("user_id");
        DB db = DB.getInstance(this);

        /*
        User u = new User("carlitos@gmail.com", "lol", "carlitos");

        db.userDao().insert(u);


        Business b = new Business("El libra", "libra@libra.com",
                "libra", "Avenida de Leganees, 3", 0, 50,
                10, "12-10", 4f);
        db.businessDao().insert(b);
        b = new Business("Peluqueria Massimo ", "cafetini@cafetini.com",
                "libra", "Avenida de la universidad, 33", 1, 50,
                10, "12-10", 4.23f);
        db.businessDao().insert(b);

        b = new Business("Los 100 Montaditos", "montaditos@libra.com",
                "libra", "Avenida de Leganes, 3", 0, 50,
                10, "12-10", 4.5f);
        db.businessDao().insert(b);
        b = new Business("Peluquería Patito Feo", "montaditos@libra.com",
                "libra", "Avenida Parla,3 ", 1, 50,
                10, "12-10", 3.8f);
        db.businessDao().insert(b);







        Reservation r = new Reservation(1, 1, "2018-04-25 12:20", 30);
        db.reservationDao().insert(r);

        Reservation a = db.reservationDao().findById(1);


        Business c = db.businessDao().findById(1);
        log = c.getName();

        */



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
            bundle.putLong("user_id", user_id);
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
        bundle.putLong("user_id", user_id);
        intent2.putExtras(bundle);
        this.startActivity(intent2);
    }
}