package com.example.funniflier2.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecentBusinessDao {
    @Query("SELECT business_id FROM RecentBusiness ORDER BY id DESC LIMIT 10")
    List<Long> getRecent();

    @Insert
    long insert(RecentBusiness recentBusiness);
}
