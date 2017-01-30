package br.com.osbdesenvolvimento.bikesorocaba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.osbdesenvolvimento.bikesorocaba.activities.MatheusActivity;
import br.com.osbdesenvolvimento.bikesorocaba.activities.PauloActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPauloActivity = (Button) findViewById(R.id.btnPauloActivity);
        btnPauloActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PauloActivity.class);
                startActivity(intent);
            }
        });

        Button btnMatheusActivity = (Button) findViewById(R.id.btnMatheusActivity);
        btnMatheusActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MatheusActivity.class);
                startActivity(intent);
            }
        });

    }
}
