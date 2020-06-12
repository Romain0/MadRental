package com.imie.madrental.WS;

public class FormWS
{
    public long id;
    public String nom;
    public String image;
    public long disponible;
    public long prixjournalierbase;
    public long promotion;
    public long agemin;
    public String categorieco2;

    public FormWS(long id, String nom, String image, long disponible, long prixjournalierbase, long promotion, long agemin, String categorieco2)
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
