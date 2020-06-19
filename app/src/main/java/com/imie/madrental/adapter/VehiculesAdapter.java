package com.imie.madrental.adapter;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.imie.madrental.DetailVehiculeActivity;
import com.imie.madrental.MainActivity;
import com.imie.madrental.R;
import com.imie.madrental.Vehicule;
import com.imie.madrental.fragment.DetailFragment;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.io.Serializable;
import java.util.List;

public class VehiculesAdapter extends RecyclerView.Adapter<VehiculesAdapter.VehiculeViewHolder>
{
    public static final String VEHICULE_DETAILS_KEY = "123";
    private List<Vehicule> listVehicules;
    private FrameLayout frameLayoutConteneurDetail = null;

    // Constructor
    public VehiculesAdapter(List<Vehicule> listVehicules)
    {
        this.listVehicules = listVehicules;
        Log.d("tagTest", "VehiculesAdapter: " + listVehicules.size());
    }

    @Override
    public VehiculeViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View viewVehicule = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicule, parent, false);
        return new VehiculeViewHolder(viewVehicule);
    }

    @Override
    public void onBindViewHolder(VehiculeViewHolder holder, int position)
    {
        String txt = listVehicules.get(position).nom + "\n" +
                listVehicules.get(position).prixjournalierbase + "\u20ac \u002f jour\n Categorie : " +
                listVehicules.get(position).categorieco2 + "\n"
                        ;
        holder.vehiculeTxTView.setText(txt);
        // img with picasso
        Log.d("tagTest", "onBindViewHolder: " + listVehicules.get(position).image);
        Picasso.with(holder.vehiculeImageView.getContext())
                .load("http://s519716619.onlinehome.fr/exchange/madrental/images/" + listVehicules.get(position).image)
                .fit()
                .centerCrop()
                .into(holder.vehiculeImageView);
    }

    @Override
    public int getItemCount()
    {
        return listVehicules.size();
    }

    public class VehiculeViewHolder extends RecyclerView.ViewHolder
    {
        public TextView vehiculeTxTView;
        public ImageView vehiculeImageView;

        public VehiculeViewHolder(@NonNull View itemView)
        {
            super(itemView);
            vehiculeTxTView = itemView.findViewById(R.id.vehiculeTxTView);
            vehiculeImageView = itemView.findViewById(R.id.vehiculeImageView);
            frameLayoutConteneurDetail = itemView.findViewById(R.id.conteneur_detail); // Il est null alors qu'il existe et que l'écran est > 600dp

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if (frameLayoutConteneurDetail != null)
                    {
                        Log.d("tagFrag", "format paysage");
                        DetailFragment fragmentDetails = new DetailFragment();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(DetailFragment.EXTRA_VEHICULE_KEY, (Serializable) listVehicules.get(getAdapterPosition()));
                        fragmentDetails.setArguments(bundle);

                        // le conteneur de la partie détail est disponible, on est donc en mode "tablette" :
                        MainActivity myContext = new MainActivity();
                        myContext.getSupportFragmentManager().beginTransaction().replace(R.id.conteneur_detail, fragmentDetails).commit();
                    }
                    else
                    {
                        Context conte = view.getContext();
                        Intent intent = new Intent(view.getContext(), DetailVehiculeActivity.class);
                        // send object to detailActivity with Parceler library
                        intent.putExtra(VEHICULE_DETAILS_KEY, Parcels.wrap(listVehicules.get(getAdapterPosition())));
                        conte.startActivity(intent);
                    }
                }
            });
        }
    }

    public static String getVEHICULE_DETAILS_KEY()
    {
        return VEHICULE_DETAILS_KEY;
    }
}
