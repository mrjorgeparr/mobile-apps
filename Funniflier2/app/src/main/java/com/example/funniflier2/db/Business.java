package com.example.funniflier2.db;

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

    @ColumnInfo(name="address")
    private String address;

    @ColumnInfo(name="type")
    private int type;

    @ColumnInfo(name="longitude")
    private float longitude;

    @ColumnInfo(name="latitude")
    private float latitude;

    @ColumnInfo(name="schedule")
    private String schedule;

    @ColumnInfo(name="rating")
    private float rating;

    public Business(String name,
                    String email,
                    String password,
                    String address,
                    int type,
                    float longitude,
                    float latitude,
                    String schedule,
                    float rating) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.schedule = schedule;
        this.rating = rating;
        this.address = address;
    }

    //Getters
    public long getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public int getType() { return type; }
    public float getLongitude() { return longitude; }
    public float getLatitude() { return latitude; }
    public String getSchedule() { return schedule; }
    public String getEmail() { return email; }
    public String getPassword () { return password; }
    public float getRating(){ return rating;}


    //Setters
    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setType(int type) { this.type = type; }
    public void setLongitude(float longitude) { this.longitude = longitude; }
    public void setLatitude(float latitude) { this.latitude = latitude; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public void setEmail(String password) { this.email = email; }
    public void setPassword (String password) { this.password = password; }
    public void setRating(float rating){this.rating = rating;}
}
