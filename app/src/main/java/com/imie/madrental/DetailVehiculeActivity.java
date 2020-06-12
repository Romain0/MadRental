package com.imie.madrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.imie.madrental.adapter.VehiculesAdapter;

public class DetailVehiculeActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datail_vahicule);

        Intent intent = getIntent();
        //MonObjet monObjet = Parcels.unwrap(getIntent().getParcelableExtra("objet"));
    }
}