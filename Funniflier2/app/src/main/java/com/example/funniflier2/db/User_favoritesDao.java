
package com.example.funniflier2.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface User_favoritesDao {
    @Query("SELECT business_id FROM User_favorites WHERE user_id=:user_id")
    List<Long> getFavorites(long user_id);

    @Insert
    long[] insert(User_favorites ... user_favorites);

    @Update
    void update(User_favorites ... user_favorites);

    @Delete
    void  delete(User_favorites user_favorites);

    @Query("DELETE FROM User_favorites WHERE business_id=:business_id AND user_id=:user_id")
    void delete_uf(long user_id, long business_id);
}

