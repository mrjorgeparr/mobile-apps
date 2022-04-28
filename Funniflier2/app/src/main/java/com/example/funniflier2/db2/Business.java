package com.example.funniflier2.db2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Business {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="email")
    private String email;

    @ColumnInfo(name="password")
    private String password;

    @ColumnInfo(name="cif")
    private String cif;

    @ColumnInfo(name="type")
    private int type;

    @ColumnInfo(name="longitude")
    private float longitude;

    @ColumnInfo(name="latitude")
    private float latitude;

    @ColumnInfo(name="rating")
    private float rating;

    @ColumnInfo(name="schedule")
    private String schedule;

    @ColumnInfo(name="attributes")
    private String attributes;

    public Business(long id,
                    String name,
                    String email,
                    String password,
                    String cif,
                    int type,
                    float longitude,
                    float latitude,
                    float rating,
                    String schedule,
                    String attributes) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cif = cif;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.rating = rating;
        this.schedule = schedule;
        this.attributes = attributes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
}
