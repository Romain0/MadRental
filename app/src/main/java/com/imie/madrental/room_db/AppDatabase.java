package com.imie.madrental.room_db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.imie.madrental.Vehicule;

@Database(entities = {Vehicule.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract VehiculeDAO coursesDAO();
}
