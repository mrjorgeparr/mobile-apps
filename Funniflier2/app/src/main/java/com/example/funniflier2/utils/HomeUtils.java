package com.example.funniflier2.utils;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.funniflier2.BusinessActivity;
import com.example.funniflier2.LoginActivity;
import com.example.funniflier2.RegisterActivity;
import com.example.funniflier2.ReservationActivity;
import com.example.funniflier2.db.Business;
import com.example.funniflier2.db.DB;
import com.example.funniflier2.db.Reservation;

public class HomeUtils {
    int backgroundColor = 0xFF6200EE;
    int textColor = Color.WHITE;
    int height, width, separation;
    long user_id;
    FragmentActivity context;
    DB db;
    public HomeUtils(FragmentActivity context){
        WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        this.width = size.x;
        this.height = 180;
        this.separation = 10;
        this.context = context;
        this.db = DB.getInstance(context);
    }


    public void putReservationOnTable(FragmentActivity context, TableLayout table, Reservation reservation){
        Business bu = db.businessDao().findById(reservation.getBusiness_id());

        // Dummy buttons in order to put separation
        Button b = new Button(this.context);
        ViewGroup.LayoutParams params = new TableRow.LayoutParams(this.width, this.separation);//ViewGroup.LayoutParams.MATCH_PARENT, height);
        b.setLayoutParams(params);
        b.setBackgroundColor(Color.WHITE);
        TableRow r = new TableRow(this.context);
        r.addView(b);
        table.addView(r);

        // Reservation button
        b = new Button(this.context);
        params = new TableRow.LayoutParams(this.width, this.height);//ViewGroup.LayoutParams.MATCH_PARENT, height);
        b.setLayoutParams(params);
        b.setBackgroundColor(backgroundColor);
        b.setTextColor(textColor);
        b.setText(bu.getName() + "\n " + reservation.getDate());

        // Takes you to a reservation activity when clicked
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(context, ReservationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putLong("reservation_id", reservation.getId());
                bundle.putLong("business_id", reservation.getBusiness_id());
                bundle.putLong("user_id", reservation.getUser_id());
                intent2.putExtras(bundle);
                context.startActivity(intent2);
            }
        });
        r = new TableRow(this.context);
        r.addView(b);
        table.addView(r);
    }

    public void putBusinessOnTable(FragmentActivity context, TableLayout table, Business business){
        String message = business.getName();
        // Dummy buttons in order to put separation
        Button b = new Button(this.context);

        ViewGroup.LayoutParams params = new TableRow.LayoutParams(this.width, this.separation);//ViewGroup.LayoutParams.MATCH_PARENT, height);
        b.setLayoutParams(params);
        b.setBackgroundColor(Color.WHITE);
        TableRow r = new TableRow(this.context);
        r.addView(b);
        table.addView(r);

        //  button
        b = new Button(this.context);
        params = new TableRow.LayoutParams(this.width, this.height);//ViewGroup.LayoutParams.MATCH_PARENT, height);
        b.setLayoutParams(params);
        b.setBackgroundColor(backgroundColor);
        b.setTextColor(textColor);
        b.setText(message);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(context, BusinessActivity.class);
                Bundle bundle = new Bundle();
                bundle.putLong("business_id", business.getId());
                bundle.putLong("user_id", user_id);
                intent2.putExtras(bundle);
                context.startActivity(intent2);
            }
        });
        r = new TableRow(this.context);
        r.addView(b);
        table.addView(r);
    }

    public void setUserId(long id){
        this.user_id = id;
    }

}
