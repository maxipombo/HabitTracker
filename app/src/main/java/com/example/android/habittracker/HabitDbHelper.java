package com.example.android.habittracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mpombos on 2/7/16.
 */
public class HabitDbHelper extends SQLiteOpenHelper {

    Context context;
    public HabitDbHelper(Context context) {
        super(context, HabitsContract.DB_NAME, null, HabitsContract.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + HabitsContract.HabitContractEntry.TABLE + " ( " +
                HabitsContract.HabitContractEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HabitsContract.HabitContractEntry.COL_HABIT_TITLE + " TEXT NOT NULL," +
                HabitsContract.HabitContractEntry.COL_HABIT_DAYS + " " +
                "INTEGER NOT NULL );";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + HabitsContract.HabitContractEntry.TABLE);
        onCreate(db);
    }

    /**
     * Delete the entire database
     * @return true if the database was successfully deleted.
     */
    public boolean deleteDatabase(){
        return context.deleteDatabase(HabitsContract.DB_NAME);
    }

}
