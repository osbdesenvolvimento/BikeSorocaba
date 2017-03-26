package br.com.osbdesenvolvimento.bikesorocaba.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;


import java.util.ArrayList;
import java.util.List;

import br.com.osbdesenvolvimento.bikesorocaba.R;
import br.com.osbdesenvolvimento.bikesorocaba.adapters.EstacaoAdapter;
import br.com.osbdesenvolvimento.bikesorocaba.classes.Interfaces;
import br.com.osbdesenvolvimento.bikesorocaba.dtos.Estacao;
import br.com.osbdesenvolvimento.bikesorocaba.tasks.DownloadJsonAsyncTask;

public class ListStationsFragment extends Fragment implements Interfaces.AsyncReturnListEstacoes {
    ListView lvEstacoes;
    RelativeLayout rlLoading;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_stations, container, false);

        rlLoading = (RelativeLayout) view.findViewById(R.id.rlLoading);
        lvEstacoes =(ListView) view.findViewById(R.id.lvEstacoes);
        new DownloadJsonAsyncTask(this).execute("https://integrabike.compartibike.com.br/stations.json");

        return view;
    }

    @Override
    public void processFinish(List<Estacao> lista) {
        ArrayList<Estacao> estacoes = (ArrayList<Estacao>) lista;
        EstacaoAdapter adapter = new EstacaoAdapter(getActivity().getApplicationContext(), estacoes);
        lvEstacoes.setAdapter(adapter);
        rlLoading.setVisibility(View.GONE);
    }
}
