package com.example.funniflier2.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ReservationDao {
    @Query("SELECT * FROM Reservation")
    List<Reservation> getAllReservations();

    @Query("SELECT * FROM Reservation WHERE id=:id")
    Reservation findById(long id);

    @Query("SELECT * FROM Reservation WHERE user_id=:user_id ORDER BY id DESC LIMIT 20")
    List<Reservation> getUserReservations(long user_id);

    @Insert
    long insert(Reservation Reservation);

    @Insert
    long[] insert(Reservation ... Reservation);

    @Update
    void update(Reservation ... Reservation);

    @Delete
    void  delete(Reservation Reservation);

}
