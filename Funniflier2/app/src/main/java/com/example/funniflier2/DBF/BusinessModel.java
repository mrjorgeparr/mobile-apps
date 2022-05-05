package com.example.funniflier2.DBF;

public class BusinessModel {
    private String id;  // this one is the primary key, their id will be given by the number of instance it is in the db
    private String CIF;
    private String address;
    private String latitude;
    private String longitude;
    private String schedule;
    private double ratings;
    private String password;
    private int capability;

    public BusinessModel(String id, String CIF, String address, String latitude, String longitude, String schedule, double ratings, String password) {
        this.id = id;
        this.CIF = CIF;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.schedule = schedule;
        this.ratings = ratings;
        this.password = password;
        this.capability = capability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BusinessModel{" +
                "id='" + id + '\'' +
                ", CIF='" + CIF + '\'' +
                ", address='" + address + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", schedule='" + schedule + '\'' +
                ", ratings=" + ratings +
                ", password='" + password + '\'' +
                '}';
    }
}
