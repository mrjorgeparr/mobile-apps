package com.example.funniflier2.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    List<User> getAllUsers();

    @Query("SELECT * FROM User WHERE id=:id")
    User findById(int id);

    @Query("SELECT * FROM User WHERE email=:email")
    boolean findByEmail(String email);

    @Query("SELECT * FROM User WHERE email=:email")
    User getByEmail(String email);

    @Insert
    long insert(User user);

    @Insert
    long[] insert(User ... user);

    @Update
    void update(User ... user);

    @Delete
    void  delete(User user);

}
