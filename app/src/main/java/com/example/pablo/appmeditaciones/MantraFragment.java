package com.example.pablo.appmeditaciones;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pablo.appmeditaciones.Modelos.Mandala;

public class MantraFragment extends Fragment {

    Mandala mandala;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mandala = (Mandala)getArguments().getSerializable("mandala");

        Log.d("DEPURACION", mandala.toString());

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mantra, container, false);
    }

    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        final TextView textViewOriginal = (TextView) getView().findViewById(R.id.textView_original);
        final TextView textViewTraducido = (TextView) getView().findViewById(R.id.textView_traducido);

        textViewOriginal.setText(mandala.getMantraOriginal());
        textViewTraducido.setText(mandala.getMantraTraducido());
    }


}
