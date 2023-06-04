package br.edu.ifsuldeminas.mch;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsuldeminas.mch.R;

public class verdade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verdade);
//
        View verdade = findViewById(R.id.verdade);

        verdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}