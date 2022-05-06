
/*
package com.example.funniflier2.db;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface User_favoritesDao {
    @Query("SELECT * FROM User_favorites")
    List<User_favorites> getAllReservations();

    @Query("SELECT * FROM User_favorites WHERE u_id=:id")
    Reservation findByUId(int id);

    @Query("SELECT * FROM User_favorites WHERE b_id=:id")
    Reservation findByBid(int id);

    @Insert
    long insert(User_favorites);

    @Insert
    long[] insert(User_favorites ... User_favorites);

    @Update
    void update(User_favorites ... User_favorites);

    @Delete
    void  delete(User_favorites User_favorites);

}
*/