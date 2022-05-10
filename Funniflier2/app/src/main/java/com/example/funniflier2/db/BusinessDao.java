package com.example.funniflier2.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BusinessDao {
    @Query("SELECT * FROM Business")
    List <Business> getAllBusinesses();

    @Query("SELECT * FROM Business WHERE id=:id ORDER BY rating")
    Business findById(long id);
    
    @Query("SELECT * FROM Business WHERE name=:name ORDER BY rating")
    Business findbyName(String name);

    @Query("SELECT * FROM Business WHERE address=:address")
    Business findByAddress(String address);

    @Query("SELECT DISTINCT * FROM Business WHERE email=:email")
    boolean findByEmail(String email);

    @Query("SELECT DISTINCT * FROM Business WHERE email=:email")
    Business getByEmail(String email);

    @Query("SELECT *, INSTR(lower(name), :str) sw FROM Business WHERE sw > 0  ORDER BY rating DESC LIMIT 20")
    List<Business> Search(String str);

    @Query("SELECT *, INSTR(lower(name), :str) sw FROM Business WHERE sw > 0 OR type=:type ORDER BY rating DESC LIMIT 20")
    List<Business> Search(String str, int type);

    @Insert
    long insert(Business Business);

    @Insert
    long[] insert(Business ... Business);

    @Update
    void update(Business ... Business);

    @Delete
    void delete(Business Business);
}
