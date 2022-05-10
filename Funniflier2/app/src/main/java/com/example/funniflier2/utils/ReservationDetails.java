package com.example.funniflier2.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationDetails {

    //date
    public int year, month, day, hour, minute;

    //ids
    public long business_id, user_id;

    public SimpleDateFormat formatter1=new SimpleDateFormat("MM-dd HH:mm");

    public ReservationDetails(){

    }

    public void setDate(int year, int month, int day){
        this.year = 2022;
        this.month = month;
        this.day = day;
    }

    public void setTime(int hour, int minute)
    {
        this.hour = hour;
        this.minute = minute;
    }

    public String toString(){
        Date date = new Date(2022, this.month, this.day, this.hour, this.minute);
        return "2022-" + formatter1.format(date);
        /*
        String s = "";
         s  = s + Integer.toString(this.year) + "-" + Integer.toString(this.month);
         s = s + Integer.toString(this.day) + " " + Integer.toString(this.hour) + ":";
         s = s + Integer.toString(this.minute);
         return s;*/
    }

    void setFromString(String date){

        try {
            Date date1 = formatter1.parse(date);

            this.year = date1.getYear();
            this.month = date1.getMonth();
            this.day = date1.getDay();
            this.hour = date1.getHours();
            this.minute = date1.getMinutes();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
