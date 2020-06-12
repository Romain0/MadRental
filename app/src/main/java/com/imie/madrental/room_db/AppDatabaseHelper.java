package com.imie.madrental.room_db;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseHelper
{

    private static AppDatabaseHelper databaseHelper = null;
    private AppDatabase database;

    // Constructor
    private AppDatabaseHelper(Context context)
    {
        database = Room.databaseBuilder(context, AppDatabase.class, "favoriteVehicule.db").allowMainThreadQueries().build();
    }

    // Getter instance
    static synchronized AppDatabase getDatabase(Context context)
    {
        if (databaseHelper == null)
        {
            databaseHelper = new AppDatabaseHelper(context.getApplicationContext());
        }
        return databaseHelper.database;
    }
}
