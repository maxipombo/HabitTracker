package com.example.android.habittracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mpombos on 2/7/16.
 */
public class HabitDbHelper extends SQLiteOpenHelper {

    public HabitDbHelper(Context context) {

        super(context, Habits.DB_NAME, null, Habits.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + Habits.HabitEntry.TABLE + " ( " +
                Habits.HabitEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Habits.HabitEntry.COL_HABIT_TITLE + " TEXT NOT NULL," +
                Habits.HabitEntry.COL_HABIT_DAYS + " " +
                "INTEGER NOT NULL );";

        db.execSQL(createTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Habits.HabitEntry.TABLE);
        onCreate(db);

    }
}
