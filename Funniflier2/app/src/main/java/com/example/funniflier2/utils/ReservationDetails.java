package com.example.funniflier2.utils;

public class ReservationDetails {

    //date
    public int year, month, day, hour, minute;

    //ids
    public int business_id, user_id;

    public ReservationDetails(){

    }

    public void setDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setTime(int hour, int minute)
    {
        this.hour = hour;
        this.minute = minute;
    }
}