package br.edu.ifsuldeminas.mch;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsuldeminas.mch.R;

public class desafio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desafio);

        View desafio = findViewById(R.id.desafio);

        desafio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
