package br.edu.ifsuldeminas.mch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Jogadores extends AppCompatActivity {

    private EditText jog1, jog2, jog3, jog4;
    private Button buttonJogar;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadores);

        jog1 = findViewById(R.id.Nome1);
        jog2 = findViewById(R.id.Nome2);
        jog3 = findViewById(R.id.Nome3);
        jog4 = findViewById(R.id.Nome4);
        buttonJogar = findViewById(R.id.buttonJogar);

        sharedPreferences = getSharedPreferences("chaveGeral", Context.MODE_PRIVATE);

        jog1.requestFocus();

        carregarDadosSalvos();

        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jogador1 = jog1.getText().toString();
                String jogador2 = jog2.getText().toString();
                String jogador3 = jog3.getText().toString();
                String jogador4 = jog4.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("chave1", jogador1);
                editor.putString("chave2", jogador2);
                editor.putString("chave3", jogador3);
                editor.putString("chave4", jogador4);
                editor.apply();

                Toast.makeText(Jogadores.this, "Dados salvos com sucesso", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(Jogadores.this, MainActivity.class));
            }
        });
    }

    private void carregarDadosSalvos() {
        String jogador1 = sharedPreferences.getString("chave1", "");
        String jogador2 = sharedPreferences.getString("chave2", "");
        String jogador3 = sharedPreferences.getString("chave3", "");
        String jogador4 = sharedPreferences.getString("chave4", "");

        jog1.setText(jogador1);
        jog2.setText(jogador2);
        jog3.setText(jogador3);
        jog4.setText(jogador4);
    }
}
