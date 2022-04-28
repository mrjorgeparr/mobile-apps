package com.example.funniflier2.db2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BusinessDao {
    @Query("SELECT * FROM Business")
    List<Business> getAllBusinesses();

    @Query("SELECT * FROM Business WHERE id=:id")
    Business findById(int id);

    @Query("SELECT * FROM Business WHERE cif=:cif")
    Business findByCif(String cif);

    @Query("SELECT DISTINCT * FROM Business WHERE email=:email")
    User findByEmail(String email);

    @Insert
    long insert(Business Business);

    @Insert
    long[] insert(Business ... Business);

    @Update
    void update(Business ... Business);

    @Delete
    void  delete(Business Business);
}
