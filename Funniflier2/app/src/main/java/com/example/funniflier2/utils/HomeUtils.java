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

public class HomeUtils {
    int backgroundColor = 0xFF6200EE;
    int textColor = Color.WHITE;
    int height, width, separation;
    FragmentActivity context;



    public HomeUtils(FragmentActivity context){
        WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        this.width = size.x;
        this.height = 180;
        this.separation = 10;
        this.context = context;
    }

    // This function appends a new reservation (row table into a table given)

    public void putReservationOnTable(FragmentActivity context, TableLayout table, String message){
        putReservationOnTable(context, table, message, 1);
    }
    public void putReservationOnTable(FragmentActivity context, TableLayout table, String message, int reservation_id){
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
        b.setText(message);

        // Takes you to a reservation activity when clicked
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(context, ReservationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("reservation_id", reservation_id);
                intent2.putExtras(bundle);
                context.startActivity(intent2);
            }
        });
        r = new TableRow(this.context);
        r.addView(b);
        table.addView(r);
    }

    public void putBusinessOnTable(FragmentActivity context, TableLayout table, String message){
        putBusinessOnTable(context, table, message, 1);
    }
    public void putBusinessOnTable(FragmentActivity context, TableLayout table, String message, int business_id){
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
        b.setText(message);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(context, BusinessActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("business_id", business_id);
                intent2.putExtras(bundle);
                context.startActivity(intent2);
            }
        });
        r = new TableRow(this.context);
        r.addView(b);
        table.addView(r);
    }

}
