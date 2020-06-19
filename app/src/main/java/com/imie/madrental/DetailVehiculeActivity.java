package com.imie.madrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.imie.madrental.adapter.VehiculesAdapter;
import com.imie.madrental.room_db.AppDatabaseHelper;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class DetailVehiculeActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vehicule);

        Vehicule vehiculeSent = Parcels.unwrap(getIntent().getParcelableExtra(VehiculesAdapter.getVEHICULE_DETAILS_KEY()));

        TextView txtVehiculeDetails = findViewById(R.id.txtVehiculeDetails);
        ImageView imgVehiculeDetails = findViewById(R.id.imgVehiculeDetails);

        String txt = vehiculeSent.nom + "\n" +
                vehiculeSent.prixjournalierbase + "\n" +
                vehiculeSent.categorieco2 + "\n";

        txtVehiculeDetails.setText(txt);
        txtVehiculeDetails.setTag(vehiculeSent);

        Picasso.with(this)
                .load("http://s519716619.onlinehome.fr/exchange/madrental/images/" + vehiculeSent.image)
                .fit()
                .centerCrop()
                .into(imgVehiculeDetails);
    }

    public void addToFavorite (View v)
    {
        // Récupération de l'id
        Log.d("tagFav", "addToFavorite: " + v.getContext().toString());

        TextView txtVehiculeDetails = findViewById(R.id.txtVehiculeDetails);
        Vehicule vehiculeSent = (Vehicule) txtVehiculeDetails.getTag();

        // Select object
        Vehicule vehiculeExist = AppDatabaseHelper.getDatabase(this).coursesDAO().findOneById((int) vehiculeSent.id);

        // if null add object
        if(vehiculeExist == null)
            AppDatabaseHelper.getDatabase(this).coursesDAO().insert(vehiculeSent);
    }
}