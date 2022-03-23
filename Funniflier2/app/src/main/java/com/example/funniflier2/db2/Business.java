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

    @ColumnInfo(name="keywords")
    private String keywords;

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
                    String keywords,
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
        this.keywords = keywords;
        this.schedule = schedule;
        this.attributes = attributes;
    }

    //Getters
    public long getId() { return id; }
    public String getName() { return name; }
    public String getCif() { return cif; }
    public int getType() { return type; }
    public float getLongitude() { return longitude; }
    public float getLatitude() { return latitude; }
    public String getKeywords() { return keywords; }
    public String getSchedule() { return schedule; }
    public String getEmail() { return email; }
    public String getPassword () { return password; }
    public String getAttributes() { return attributes;}


    //Setters
    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCif(String cif) { this.cif = cif; }
    public void setType(int type) { this.type = type; }
    public void setLongitude(float longitude) { this.longitude = longitude; }
    public void setLatitude(float latitude) { this.latitude = latitude; }
    public void setKeywords(String keywords) { this.keywords = keywords; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public void setEmail(String password) { this.email = email; }
    public void setPassword (String password) { this.password = password; }
    public void setAttributes(String attributes) { this.attributes = attributes;}
}
