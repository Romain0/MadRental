package com.imie.madrental.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.imie.madrental.R;
import com.imie.madrental.Vehicule;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment
{
    public static final String EXTRA_VEHICULE_KEY = "VAL";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        if (getView() != null && getContext() != null && getArguments() != null)
        {
            Vehicule vehiculeSent = (Vehicule) getArguments().getSerializable(EXTRA_VEHICULE_KEY);

            String txt = vehiculeSent.nom + "\n" +
                    vehiculeSent.prixjournalierbase + "\n" +
                    vehiculeSent.categorieco2 + "\n"
                    ;

            TextView textViewVehicule = getView().findViewById(R.id.textViewVehicule);
            textViewVehicule.setText(txt);

            ImageView imageViewVehicule = getView().findViewById(R.id.imageViewVehicule);
            Picasso.with(getContext())
                    .load("http://s519716619.onlinehome.fr/exchange/madrental/images/" + vehiculeSent.image)
                    .fit()
                    .centerCrop()
                    .into(imageViewVehicule);
        }
    }
}