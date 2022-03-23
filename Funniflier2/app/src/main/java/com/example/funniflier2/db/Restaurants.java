package com.example.funniflier2.db;

public class Restaurants {
    private String b_id;
    private String capacity;
    private String menu;

    public Restaurants(String b_id, String cap, String menu){
        this.b_id = b_id;
        this.capacity = capacity;
        this.menu = menu;
    }


    // getter and setter method
    public String getB_id() {
        return b_id;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getMenu() {
        return menu;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
