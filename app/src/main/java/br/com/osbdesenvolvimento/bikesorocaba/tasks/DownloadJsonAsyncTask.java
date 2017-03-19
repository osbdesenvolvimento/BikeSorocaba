package br.com.osbdesenvolvimento.bikesorocaba.tasks;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import br.com.osbdesenvolvimento.bikesorocaba.adapters.EstacaoAdapter;
import br.com.osbdesenvolvimento.bikesorocaba.classes.Interfaces;
import br.com.osbdesenvolvimento.bikesorocaba.dtos.Estacao;
import br.com.osbdesenvolvimento.bikesorocaba.fragments.MapFragment;

public class DownloadJsonAsyncTask extends AsyncTask<String, Void, ArrayList<Estacao>> {

    MapFragment mapFragment;
    View view;
    Interfaces.AsyncReturnListEstacoes interCall = null;

    public DownloadJsonAsyncTask(MapFragment contextFrag, Interfaces.AsyncReturnListEstacoes interCall) {
        this.mapFragment = contextFrag;
        this.interCall = interCall;
    }

    public DownloadJsonAsyncTask(View view) {
        this.view = view;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Estacao> doInBackground(String... params) {

        ArrayList<Estacao> estacoes = new ArrayList<>();

        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String value = bf.readLine();

            // Estações
            JSONArray estacoesJson = new JSONArray(value);
            for (int i = 0; i < estacoesJson.length(); i++) {

                // Estação
                JSONObject estacaoJson = (JSONObject) estacoesJson.get(i);
                Estacao estacao = new Estacao();

                estacao.setId(estacaoJson.getInt("id"));
                estacao.setStationNumber(estacaoJson.getInt("station_number"));
                estacao.setName(estacaoJson.getString("name"));
                estacao.setGoogleMapX(estacaoJson.getDouble("googleMapX"));
                estacao.setGoogleMapY(estacaoJson.getDouble("googleMapY"));
                estacao.setStatus(estacaoJson.getString("status"));
                estacao.setUpdatedAt(estacaoJson.getString("updated_at"));
                estacao.setAvailableSlotsSize(estacaoJson.getInt("available_slots_size"));
                estacao.setUnavailableSlotsSize(estacaoJson.getInt("unavailable_slots_size"));

                // Adicionando as estações localizadas
                estacoes.add(estacao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return estacoes;
    }

    @Override
    protected void onPostExecute(ArrayList<Estacao> estacoes) {
        if (interCall != null) {
            interCall.processFinish(estacoes);
        } else if (view != null) {
            ListView lvEstacoes = (ListView) view;
            EstacaoAdapter adapter = new EstacaoAdapter(view.getContext(), estacoes);
            lvEstacoes.setAdapter(adapter);
        }
    }
}














