package com.example.android.habittracker;

import android.provider.BaseColumns;

/**
 * Created by mpombos on 2/7/16.
 */
public class Habits {

    public Habits() {
        
    }

    public static final String DB_NAME = "com.example.android.habittracker.db";
    public static final int DB_VERSION = 2;

    public class HabitEntry implements BaseColumns {
        public static final String TABLE = "habits";
        public static final String ID = "id";
        public static final String COL_HABIT_TITLE = "title";
        public static final String COL_HABIT_DAYS = "days";
    }

}
