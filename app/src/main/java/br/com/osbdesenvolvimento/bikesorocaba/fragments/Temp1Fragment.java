package br.com.osbdesenvolvimento.bikesorocaba.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.osbdesenvolvimento.bikesorocaba.MainActivity;
import br.com.osbdesenvolvimento.bikesorocaba.R;
import br.com.osbdesenvolvimento.bikesorocaba.activities.MatheusActivity;
import br.com.osbdesenvolvimento.bikesorocaba.activities.PauloActivity;

public class Temp1Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_temp1, container, false);

        Button btnPauloActivity = (Button) view.findViewById(R.id.btnPauloActivity);
        btnPauloActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PauloActivity.class);
                startActivity(intent);
            }
        });

        Button btnMatheusActivity = (Button) view.findViewById(R.id.btnMatheusActivity);
        btnMatheusActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MatheusActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}
