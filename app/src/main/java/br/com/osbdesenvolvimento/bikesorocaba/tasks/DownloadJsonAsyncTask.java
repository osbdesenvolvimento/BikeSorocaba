package br.com.osbdesenvolvimento.bikesorocaba.tasks;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.osbdesenvolvimento.bikesorocaba.dtos.Bicicleta;
import br.com.osbdesenvolvimento.bikesorocaba.dtos.Estacao;

public class DownloadJsonAsyncTask extends AsyncTask<String, Void, List<Estacao>> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(List<Estacao> estacoes) {
        super.onPostExecute(estacoes);
    }

    @Override
    protected List<Estacao> doInBackground(String... params) {

        List<Estacao> estacoes = new ArrayList<>();
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
                estacao.setAddress(estacaoJson.getString("address"));
                estacao.setCreatedAt(estacaoJson.getString("created_at"));
                estacao.setDescription(estacaoJson.getString("description"));
                estacao.setGoogleMapX(estacaoJson.getString("googleMapX"));
                estacao.setGoogleMapY(estacaoJson.getString("googleMapY"));
                estacao.setId(estacaoJson.getString("id"));
                estacao.setMapX(estacaoJson.getString("mapX"));
                estacao.setMapY(estacaoJson.getString("mapY"));
                estacao.setName(estacaoJson.getString("name"));
                estacao.setNumberLeftSlots(estacaoJson.getString("number_left_slots"));
                estacao.setNumberRightSlots(estacaoJson.getString("number_right_slots"));
                estacao.setPassword(estacaoJson.getString("password"));
                estacao.setStationNumber(estacaoJson.getString("station_number"));
                estacao.setStatus(estacaoJson.getString("status"));
                estacao.setTotalBikes(estacaoJson.getString("total_bikes"));
                estacao.setTypeStation(estacaoJson.getString("type_station"));
                estacao.setUpdatedAt(estacaoJson.getString("updated_at"));
                estacao.setAvailableSlotsSize(estacaoJson.getString("available_slots_size"));
                estacao.setUnavailableSlotsSize(estacaoJson.getString("unavailable_slots_size"));
                estacao.setStatusToHuman(estacaoJson.getString("status_to_human"));

                // Bicicletas
                JSONArray bicicletasJson = estacaoJson.getJSONArray("bikes");
                List<Bicicleta> bicicletas = new ArrayList<>();
                for (int x = 0; x < bicicletasJson.length(); x++) {

                    // Bicicleta
                    JSONObject bicicletaJson = (JSONObject) bicicletasJson.get(x);
                    Bicicleta bicicleta = new Bicicleta();

                    bicicleta.setAcquisitionDate(bicicletaJson.getString("acquisition_date"));
                    bicicleta.setBikeHardId(bicicletaJson.getString("bike_hard_id"));
                    bicicleta.setCreatedAt(bicicletaJson.getString("created_at"));
                    bicicleta.setDeletedAt(bicicletaJson.getString("deleted_at"));
                    bicicleta.setId(bicicletaJson.getString("id"));
                    bicicleta.setLastReceived(bicicletaJson.getString("last_received"));
                    bicicleta.setLastStationId(bicicletaJson.getString("last_station_id"));
                    bicicleta.setModel(bicicletaJson.getString("model"));
                    bicicleta.setRfid(bicicletaJson.getString("rfid"));
                    bicicleta.setStationId(bicicletaJson.getString("station_id"));
                    bicicleta.setStatus(bicicletaJson.getString("status"));
                    bicicleta.setUpdatedAt(bicicletaJson.getString("updated_at"));

                    bicicletas.add(bicicleta);
                }

                // Adicionando as bicicletas da estação
                estacao.setBikes(bicicletas);

                // Adicionando as estações localizadas
                estacoes.add(estacao);

                Log.d("[Teste]", estacao.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return estacoes;
    }
}
