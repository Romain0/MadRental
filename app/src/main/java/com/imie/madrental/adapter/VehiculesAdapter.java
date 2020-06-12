package com.imie.madrental.adapter;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.imie.madrental.R;
import com.imie.madrental.Vehicule;

import java.util.List;

public class VehiculesAdapter extends RecyclerView.Adapter<VehiculeViewHolder>
{
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
        holder.vehiculeTxTView.setText(listVehicules.get(position).nom);
        /*holder.vehiculeTxTView.setText((int) listVehicules.get(position).prixJournalier);
        holder.vehiculeTxTView.setText(listVehicules.get(position).categ);
        holder.vehiculeTxTView.setText(listVehicules.get(position).inmg);*/
    }

    @Override
    public int getItemCount()
    {
        return listVehicules.size();
    }


}
