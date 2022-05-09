package com.example.funniflier2.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

//@Entity(indices = [Index(value = ["name"], unique = true)]
@Entity(foreignKeys = {
        @ForeignKey(entity = User.class,
                parentColumns = "id",
                childColumns = "user_id",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Business.class,
                parentColumns = "id",
                childColumns = "business_id",
                onDelete = ForeignKey.CASCADE)
})

public class User_favorites {
    @PrimaryKey
    private long id;

    @ColumnInfo(name="user_id")
    private long user_id;

    @ColumnInfo(name="business_id")
    private long business_id;
}
