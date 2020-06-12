package com.imie.madrental;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "vehicules")
public class Vehicule
{
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String nom;
    public String inmg;
    public boolean dispo;
    public float prixJournalier;
    public float promotion;
    public int ageMin;
    public char categ;

    // Constructors
    public Vehicule() {}

    public Vehicule(long id, String nom, String inmg, boolean dispo, float prixJournalier, float promotion, int ageMin, char categ)
    {
        this.id = id;
        this.nom = nom;
        this.inmg = inmg;
        this.dispo = dispo;
        this.prixJournalier = prixJournalier;
        this.promotion = promotion;
        this.ageMin = ageMin;
        this.categ = categ;
    }
}
