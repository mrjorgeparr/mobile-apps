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
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name="user_id")
    private long user_id;

    @ColumnInfo(name="business_id")
    private long business_id;

    public User_favorites(long user_id, long business_id){
        this.user_id = user_id;
        this.business_id = business_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(long business_id) {
        this.business_id = business_id;
    }
}
