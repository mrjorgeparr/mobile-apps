package com.example.funniflier2.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RecentBusiness {
    @PrimaryKey(autoGenerate = true)
    long id;

    @ColumnInfo
    long business_id;

    public RecentBusiness(long business_id) {
        this.business_id = business_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(long business_id) {
        this.business_id = business_id;
    }
}
