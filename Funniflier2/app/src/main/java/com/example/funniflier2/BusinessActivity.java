package com.example.funniflier2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.funniflier2.utils.ReservationDetails;

import java.util.Calendar;

public class BusinessActivity extends AppCompatActivity {

    int business_id, user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
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
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
        writeOnDB(reservation);

        Toast.makeText(this, "Reservation Completed", Toast.LENGTH_LONG);
    }

    private void writeOnDB(ReservationDetails reservation) {
        // this method calls the database an registers the reservation
        Log.d("message", "mYear: " + Integer.toString(reservation.year) + " mMonth: "+Integer.toString(reservation.month) +" mDay: " + Integer.toString(reservation.day));
        Log.d("message", "hour: " + Integer.toString(reservation.hour) + " minute: "+Integer.toString(reservation.minute));

        return;
    }

    public void goToMaps(View v) {
        Intent intent2 = new Intent(this, MapsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("business_id", business_id);
        intent2.putExtras(bundle);
        this.startActivity(intent2);
    }
    public void rate(View v){
        return;
    }
}