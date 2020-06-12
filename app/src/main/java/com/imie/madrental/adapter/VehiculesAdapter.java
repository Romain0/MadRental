package com.imie.madrental.adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imie.madrental.DetailVehiculeActivity;
import com.imie.madrental.R;
import com.imie.madrental.Vehicule;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VehiculesAdapter extends RecyclerView.Adapter<VehiculesAdapter.VehiculeViewHolder>
{
    public final String VEHICULE_DETAILS_KEY = "123";
    private List<Vehicule> listVehicules;

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
                listVehicules.get(position).prixjournalierbase + "\n" +
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

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Context conte = view.getContext();
                    Intent intent = new Intent(view.getContext(), DetailVehiculeActivity.class);
                    //intent.putExtra("objet", Parcels.wrap(monObjet));
                    intent.putExtra(VEHICULE_DETAILS_KEY, listVehicules.get(getAdapterPosition()).nom);
                    conte.startActivity(intent);

                    // REGARDER LIBRARY PARCELABLE
                }
            });
        }
    }

}
