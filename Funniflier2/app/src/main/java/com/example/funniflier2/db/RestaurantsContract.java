package com.example.funniflier2.db;

import android.provider.BaseColumns;

public class RestaurantsContract {
    public static abstract class RestaurantsEntry implements BaseColumns {
        public static final String TABLE_NAME ="Restaurants";
        public static final String B_ID = "business_id";
        public static final String MENU = "menu";
    }
}
