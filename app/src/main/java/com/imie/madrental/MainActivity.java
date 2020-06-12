package com.imie.madrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.imie.madrental.WS.ResultWS;
import com.imie.madrental.adapter.VehiculesAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity
{
    public final String TAG = "tagTest";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // init
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Recycler view
        RecyclerView recyclerView = findViewById(R.id.listVehicule);

        // better perform
        recyclerView.setHasFixedSize(true);

        // layout manager, décrivant comment les items sont disposés :
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // get values
        // client HTTP :
        AsyncHttpClient client = new AsyncHttpClient();
        // call WS
        client.post("http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php", new AsyncHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response)
            {
                // response
                String wsResponse = new String(response);
                // conversion en un objet Java (à faire!) ayant le même format que le JSON :
                Gson gson = new Gson();
                ResultWS retourWS = gson.fromJson(wsResponse, ResultWS.class);
                // affichage d'un attribut :
                Log.i(TAG, "retour : " + retourWS.form.vehicule);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers,byte[] errorResponse, Throwable e)
            {
                Log.e(TAG, e.toString());
            }
        });

        // Test
        List<Vehicule> listVehicules = new ArrayList<>();
        listVehicules.add(new Vehicule(1, "pomme", "test", true, 10, 5, 12, 'A'));
        listVehicules.add(new Vehicule(2, "poire", "test", true, 10, 5, 12, 'A'));
        listVehicules.add(new Vehicule(2, "fraise", "test", true, 10, 5, 12, 'A'));
        listVehicules.add(new Vehicule(2, "framboise", "test", true, 10, 5, 12, 'A'));
        listVehicules.add(new Vehicule(2, "cerise", "test", true, 10, 5, 12, 'A'));
        listVehicules.add(new Vehicule(2, "mure", "test", true, 10, 5, 12, 'A'));
        /*List<Vehicule> listVehicules = AppDatabaseHelper
                .getDatabase(this)
                .vehiculeDAO()
                .findAllVehicules();*/

        // adapter
        VehiculesAdapter vehiculesAdapter = new VehiculesAdapter(listVehicules);
        recyclerView.setAdapter(vehiculesAdapter);
    }

    public void clickButton(View view)
    {
        // code pour afficher les favoris
    }
}