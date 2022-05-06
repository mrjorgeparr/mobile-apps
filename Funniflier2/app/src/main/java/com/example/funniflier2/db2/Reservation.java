package com.example.funniflier2.db2;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Business.class,
        parentColumns = "id",
        childColumns = "business_id",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Business.class,
                parentColumns = "id",
                childColumns = "business_id",
                onDelete = ForeignKey.CASCADE)
})

public class Reservation {

    @PrimaryKey
    private long id;

    @ColumnInfo(name="user_id")
    private long user_id;

    @ColumnInfo(name="business_id")
    private long business_id;

    @ColumnInfo(name="date")
    private String date;

    @ColumnInfo(name="duration")
    private int duration = 30;

    public Reservation(long id, long user_id, long business_id, String date, int duration) {
        this.id = id;
        this.user_id = user_id;
        this.business_id = business_id;
        this.date = date;
        this.duration = duration;
    }

    //Getters
    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public long getBusiness_id() {
        return business_id;
    }

    public String getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    //Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setBusiness_id(long business_id) {
        this.business_id = business_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
