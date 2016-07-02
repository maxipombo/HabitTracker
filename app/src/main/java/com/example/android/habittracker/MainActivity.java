package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    HabitDbHelper mHelper;
    SQLiteDatabase db;
    ContentValues values = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHelper = new HabitDbHelper(this);
        db = mHelper.getWritableDatabase();

        // All the method calls for insert, delete, retrieve, update methods

        insertData("Sleeping", "14");
        insertData("Studying", "15");
        insertData("Eating", "7");
        updateData("Watching a movie", "3");
        getData();
        deleteAllData();

    }

    // Method to insert data

    public boolean insertData(String habit, String days) {


        values.put(Habits.HabitEntry.COL_HABIT_TITLE, habit);
        values.put(Habits.HabitEntry.COL_HABIT_DAYS, days);

        long rowId = db.insert(Habits.HabitEntry.TABLE, null, values);

        return rowId != -1;

    }

    // Method to retrieve data

    public Cursor getData() {
        Cursor res = db.rawQuery("SELECT * FROM " + Habits.HabitEntry.TABLE, null);
        return res;
    }

    // Method to update data

    public boolean updateData(String habit, String days) {
        values.put(Habits.HabitEntry.COL_HABIT_DAYS, days);
        db.update(Habits.HabitEntry.TABLE,
                values,
                Habits.HabitEntry.COL_HABIT_TITLE + "= ?",
                new String[]{habit});
        return true;
    }

    // Method to delete all data

    public Integer deleteAllData() {

        return db.delete(Habits.HabitEntry.TABLE, null, null);

    }
}