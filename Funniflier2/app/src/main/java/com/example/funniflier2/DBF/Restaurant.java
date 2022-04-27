package com.example.funniflier2.DBF;

public class Restaurant {
    private int b_id;
    private int capability;
    private String menu;

    public Restaurant(int b_id, int capability, String menu) {
        this.b_id = b_id;
        this.capability = capability;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "b_id=" + b_id +
                ", capability=" + capability +
                ", menu='" + menu + '\'' +
                '}';
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getCapability() {
        return capability;
    }

    public void setCapability(int capability) {
        this.capability = capability;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
