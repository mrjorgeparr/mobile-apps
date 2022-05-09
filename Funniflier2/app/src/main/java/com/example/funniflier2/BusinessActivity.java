package com.example.funniflier2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.funniflier2.db.Business;
import com.example.funniflier2.db.DB;
import com.example.funniflier2.db.Reservation;
import com.example.funniflier2.utils.ReservationDetails;

import java.util.Calendar;

public class BusinessActivity extends AppCompatActivity {

    long business_id, user_id;
    Business business;
    DB db = DB.getInstance(this);
    boolean ready = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        Bundle extras = getIntent().getExtras();

        business_id = extras.getLong("business_id");
        user_id = extras.getLong("user_id");
        business = db.businessDao().findById(business_id);

        RatingBar rating = (RatingBar) findViewById(R.id.business_rating);
        TextView name = (TextView) findViewById(R.id.business_name_title);
        TextView type = (TextView) findViewById(R.id.business_services);
        TextView address = (TextView) findViewById(R.id.business_activity_address);
        TextView schedule = (TextView) findViewById(R.id.business_activity_schedule);

        rating.setRating(business.getRating());
        name.setText(business.getName());
        address.setText(business.getAddress());
        if (business.getType() == 1){
            type.setText("Restaurant");
        }else{
            type.setText("Hairdresser");
        }
        schedule.setText("Open: " + business.getSchedule());




        Switch sw = (Switch) findViewById(R.id.business_favorites);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                } else {
                    // The toggle is disabled
                }
            }
        });

    }

    public void reserve(View V){

        ReservationDetails reservation = new ReservationDetails();

        // Pick a date
        Calendar c = Calendar.getInstance();

        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        reservation.setDate(year, monthOfYear, dayOfMonth);
                        writeOnDB(reservation);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();


        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        reservation.setTime(hourOfDay, minute);
                        writeOnDB(reservation);

                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void writeOnDB(ReservationDetails reservation) {

        if (ready == false){
            ready = true;
            return;
        }

        ready = false;
        Reservation re = new Reservation(user_id, business_id, reservation.toString(), 30);
        Toast.makeText(this, "Reservation Completed ", Toast.LENGTH_LONG).show();
        goToHome();
        return;
    }

    public void goToMaps(View v) {
        Intent intent2 = new Intent(this, MapsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putFloat("long", business.getLongitude());
        bundle.putFloat("lat", business.getLatitude());
        bundle.putString("name", business.getName());
        intent2.putExtras(bundle);
        this.startActivity(intent2);
    }


    public void goToHome(){
        Intent intent2 = new Intent(this, HomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putLong("user_id", user_id);
        intent2.putExtras(bundle);
        this.startActivity(intent2);
    }

}