package com.imie.madrental.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imie.madrental.R;

public class VehiculeViewHolder extends RecyclerView.ViewHolder
{
    public TextView vehiculeTxTView;
    public VehiculeViewHolder(@NonNull View itemView)
    {
        super(itemView);
        vehiculeTxTView = itemView.findViewById(R.id.vehiculeTxTView);
    }
}
