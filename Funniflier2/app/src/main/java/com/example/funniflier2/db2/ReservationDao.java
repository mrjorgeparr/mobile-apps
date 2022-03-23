package com.example.funniflier2.db2;

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
    Reservation findById(int id);

    @Insert
    long insert(Reservation Reservation);

    @Insert
    long[] insert(Reservation ... Reservation);

    @Update
    void update(Reservation ... Reservation);

    @Delete
    void  delete(Reservation Reservation);

}
