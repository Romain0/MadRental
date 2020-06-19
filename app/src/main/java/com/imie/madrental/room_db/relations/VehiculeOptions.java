package com.imie.madrental.room_db.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.imie.madrental.Option;
import com.imie.madrental.Vehicule;

import java.util.List;

public class VehiculeOptions
{
    @Embedded
    public Vehicule vehicule;

    // 1 - n
    @Relation(parentColumn = "idVehicule", entityColumn = "optionId")
    public List<Option> options;
}
