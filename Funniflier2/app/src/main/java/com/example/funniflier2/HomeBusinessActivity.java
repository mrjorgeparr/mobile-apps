package com.example.funniflier2;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.funniflier2.databinding.FragmentHomeBinding;
import com.example.funniflier2.db.DB;
import com.example.funniflier2.db.Reservation;
import com.example.funniflier2.ui.home.ReservationsFragment;
import com.example.funniflier2.utils.HomeUtils;

import java.util.List;

public class HomeBusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_business_home);

            Bundle bundle = getIntent().getExtras();
            DB db = DB.getInstance(this);
            long id = bundle.getLong("business_id");

            TableLayout table = (TableLayout) findViewById(R.id.table_business);
            HomeUtils hu = new HomeUtils(this);
            hu.setUserId(0);

            List<Reservation> reservations = db.reservationDao().getBusinessReservations(id);
            for(int i=0; i< reservations.size(); i++){
                hu.putReservationOnTable(this, table, reservations.get(i));
            }
    }
}