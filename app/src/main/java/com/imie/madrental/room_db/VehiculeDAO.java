package com.imie.madrental.room_db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.imie.madrental.Vehicule;

import java.util.List;

@Dao
public abstract class VehiculeDAO
{
    @Query("SELECT * FROM vehicules")
    public abstract List<Vehicule> findAllVehicules();

    @Insert
    public abstract void insert(Vehicule... vehicules);

    @Update
    public abstract void update(Vehicule... vehicules);

    @Delete
    public abstract void delete(Vehicule... vehicules);
}
