
package com.example.funniflier2.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface User_favoritesDao {
    @Query("SELECT * FROM User_favorites WHERE user_id=:user_id")
    List<Long> getFavorites(long user_id);

    @Query("SELECT * FROM User_favorites WHERE user_id=:id")
    Reservation findByUId(int id);

    @Query("SELECT * FROM User_favorites WHERE business_id=:id")
    Reservation findByBid(int id);

    @Insert
    long[] insert(User_favorites ... user_favorites);

    @Update
    void update(User_favorites ... user_favorites);

    @Delete
    void  delete(User_favorites user_favorites);

}

