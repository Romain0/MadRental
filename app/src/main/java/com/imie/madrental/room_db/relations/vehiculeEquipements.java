package com.imie.madrental.room_db.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.imie.madrental.Equipement;
import com.imie.madrental.Vehicule;

import java.util.List;

public class vehiculeEquipements
{
    @Embedded
    public Vehicule vehicule;

    public class VehiculeEquipements
    {
        @Embedded
        public Vehicule vehicule;

        @Relation(parentColumn = "idVehicule", entityColumn = "equipementId")
        public List<Equipement> equipements;
    }
}
