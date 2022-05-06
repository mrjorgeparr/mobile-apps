package com.example.funniflier2.db2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Business.class}, version = 7)
public abstract class DB extends RoomDatabase {

    private static final boolean preloadDB = false;
    private static final String PRELOADED_DATABASE_FILE = "testing1";
    private static final String DB_NAME = "funniflier";
    private static volatile DB instance;
    public abstract UserDao userDao();
    public abstract BusinessDao businessDao();
    public abstract ReservationDao reservationDao();


    public static synchronized DB getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static DB create(Context context) {
        if (preloadDB) {
            return Room.databaseBuilder(context, DB.class, DB_NAME)
                    .createFromAsset(PRELOADED_DATABASE_FILE)
                    .allowMainThreadQueries()
                    .build();
        }
        return Room.databaseBuilder(context, DB.class, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
}