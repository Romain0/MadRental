package com.imie.madrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;
import com.imie.madrental.WS.ResultWS;
import com.imie.madrental.adapter.VehiculesAdapter;
import com.imie.madrental.room_db.AppDatabaseHelper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.Arrays;
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

        // call WS
        this.webServiceResult();
    }

    // Button management
    public void clickButton(View view)
    {
        switch (view.getId())
        {
/*            case R.id.vehiculeItem :
                Intent intent = new Intent(this, DatailVahiculeActivity.class);
                this.startActivity(intent);
                break;*/
            case R.id.favBtn :
                Log.d(TAG, "clickButton: ");

                Switch favBtn = view.findViewById(R.id.favBtn);

                if(favBtn.isChecked())
                {
                    List<Vehicule> vehiculeList = AppDatabaseHelper.getDatabase(this).coursesDAO().findAllVehicules();
                    VehiculesAdapter vehiculesAdapter = new VehiculesAdapter(vehiculeList);

                    // Recycler view
                    RecyclerView recyclerView = findViewById(R.id.listVehicule);

                    // better perform
                    recyclerView.setHasFixedSize(true);

                    // layout manager, décrivant comment les items sont disposés :
                    LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
                    recyclerView.setLayoutManager(layoutManager);

                    recyclerView.setAdapter(vehiculesAdapter);
                }
                else
                {
                    // call WS too
                    this.webServiceResult();
                }

                break;
            default:
                Toast.makeText(this, "Bouton inconnu", Toast.LENGTH_SHORT).show();
        }
    }

    private void webServiceResult()
    {
        // get values with HTTP client
        AsyncHttpClient client = new AsyncHttpClient();
        // call WS
        client.post("http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php", new AsyncHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response)
            {
                // response
                String wsResponse = new String(response);
                Log.d(TAG, "onSuccess: " + wsResponse); // OK

                Gson gson = new Gson();
                // Java Conversion
                Vehicule[] enums = gson.fromJson(wsResponse, Vehicule[].class);
                VehiculesAdapter vehiculesAdapter = new VehiculesAdapter(Arrays.asList(enums));

                // Recycler view
                RecyclerView recyclerView = findViewById(R.id.listVehicule);

                // better perform
                recyclerView.setHasFixedSize(true);

                // layout manager, décrivant comment les items sont disposés :
                LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
                recyclerView.setLayoutManager(layoutManager);

                recyclerView.setAdapter(vehiculesAdapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers,byte[] errorResponse, Throwable e)
            {
                Log.e(TAG, e.toString());
            }
        });
    }
}