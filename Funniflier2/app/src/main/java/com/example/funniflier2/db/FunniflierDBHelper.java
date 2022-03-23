package com.example.funniflier2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FunniflierDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Funniflier.db";

    public FunniflierDBHelper(Context context) {
        /*We use super to make use of the methods of the helper, by inheritance*/

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // SQL COMMANDS DEFINED IN SQLLITE for table creation.txt
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // COMMANDS RELATED TO MODIFICATION OF THE TABLE
    }
    // one of these methods per table? makes sense

    /*
    @Override
    public void onCreateUsers(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UserEntry.NAME + " TEXT NOT NULL,"
                + UserEntry.SURNAME1 + " TEXT NOT NULL,"
                + UserEntry.SURNAME2 + " TEXT NOT NULL,"
                + UserEntry.EMAIL + " TEXT NOT NULL,"
                + "UNIQUE (" + UserEntry.ID + "))");

    }*/



}
