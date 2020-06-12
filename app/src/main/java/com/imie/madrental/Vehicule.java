package com.imie.madrental;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "vehicules")
public class Vehicule
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
