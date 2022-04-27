package com.example.funniflier2.DBF;

public class Reservations {
    private int b_id;       // reservations must be linked to a business, and a user at a particular time, the tuple of the three serves as primary key
    private int u_id;
    private String date;

    public Reservations(int b_id, int u_id, String date) {
        this.b_id = b_id;
        this.u_id = u_id;
        this.date = date;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
