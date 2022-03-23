package com.example.funniflier2.db;

import android.provider.BaseColumns;

public class HairdresserContract {
    public static abstract class HairdresserEntry implements BaseColumns {
        public static final String TABLE_NAME ="Hairdressers";
        public static final String B_ID = "business_id";
        public static final String MENU = "nbarbers";
    }
}
