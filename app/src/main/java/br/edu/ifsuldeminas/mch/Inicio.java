package br.edu.ifsuldeminas.mch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Inicio extends AppCompatActivity {

    Button buttonIniciar;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        progressBar = findViewById(R.id.progressBarID);
        buttonIniciar = findViewById(R.id.buttonIniciar);

        buttonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                new android.os.CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Faz algo durante a contagem regressiva (se necessário)
                    }

                    public void onFinish() {
                        startActivity(new Intent(Inicio.this, Jogadores.class));
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }.start();            }
        });
    }
}
