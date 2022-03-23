package com.example.funniflier2.db;

import android.provider.BaseColumns;

public class UserFavoritesContract {
    public static abstract class UserFavoriteEntry implements BaseColumns {
        public static final String TABLE_NAME ="User_favourites";
        public static final String ID = "id";
        public static final String CUSTOMER_ID = "customer_id";
        public static final String BUSINESS_ID = "business_id";
    }
}