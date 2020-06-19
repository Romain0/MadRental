package com.imie.madrental;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.parceler.Parcel;

import java.io.Serializable;

@Parcel
@Entity(tableName = "vehicules")
public class Vehicule implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String nom;
    public String image;
    public long disponible;
    public long prixjournalierbase;
    public long promotion;
    public long agemin;
    public String categorieco2;

/*
Error :
 En effet il faudrait ajouter une table de relation entre les objets Vehicule > Option et Vehicule > Equipement

D:\Romain\Documents\androidStudioLibrary\MadRental\app\src\main\java\com\imie\madrental\Vehicule.java:23: error: Cannot figure out how to save this field into database. You can consider adding a type converter for it.
    public List<List<String>> equipementsList;
*/

    // Constructors
    public Vehicule() {}

    public Vehicule(long id, String nom, String image, long disponible, long prixjournalierbase, long promotion, long agemin, String categorieco2)
    {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.disponible = disponible;
        this.prixjournalierbase = prixjournalierbase;
        this.promotion = promotion;
        this.agemin = agemin;
        this.categorieco2 = categorieco2;
    }
}
