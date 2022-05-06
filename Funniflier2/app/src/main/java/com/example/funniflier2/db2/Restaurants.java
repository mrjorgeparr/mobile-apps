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
public class Restaurants {

    @PrimaryKey
    private long id;

    @ColumnInfo(name="type")
    private long user_id;

    public void Reservation(long id, long user_id, long business_id, String date, int duration) {
        this.id = id;
        this.user_id = user_id;
        this.business_id = business_id;
        this.date = date;
        this.duration = duration;
    }


}
