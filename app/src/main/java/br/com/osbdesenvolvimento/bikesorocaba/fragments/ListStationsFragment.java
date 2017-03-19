package br.com.osbdesenvolvimento.bikesorocaba.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.osbdesenvolvimento.bikesorocaba.R;
import br.com.osbdesenvolvimento.bikesorocaba.tasks.DownloadJsonAsyncTask;

public class ListStationsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_stations, container, false);
        new DownloadJsonAsyncTask(view.findViewById(R.id.lvEstacoes)).execute("https://integrabike.compartibike.com.br/stations.json");

        return view;
    }

}
