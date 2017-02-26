package br.com.osbdesenvolvimento.bikesorocaba.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import br.com.osbdesenvolvimento.bikesorocaba.R;
import br.com.osbdesenvolvimento.bikesorocaba.tasks.DownloadJsonAsyncTask;

public class MatheusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matheus);

        new DownloadJsonAsyncTask(this.findViewById(R.id.lvEstacoes)).execute("https://integrabike.compartibike.com.br/stations.json");
    }
}
