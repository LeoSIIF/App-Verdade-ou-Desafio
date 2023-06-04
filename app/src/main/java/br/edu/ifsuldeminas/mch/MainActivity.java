package br.edu.ifsuldeminas.mch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView garrafa;
    private Random random = new Random();
    private int ultimaDirecao;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        garrafa = findViewById(R.id.garrafa);

        ImageView voltar = findViewById(R.id.voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Jogadores.class);
                startActivity(intent);
            }
        });

        garrafa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int novaDirecao = random.nextInt(1800);
                float eixoX = garrafa.getWidth() / 2;
                float eixoY = garrafa.getHeight() / 2;

                Animation girar = new RotateAnimation(ultimaDirecao, novaDirecao, eixoY, eixoX);
                girar.setDuration(2500);
                girar.setFillAfter(true);

                ultimaDirecao = novaDirecao;

                girar.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // Chamado quando a animação começa
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Chamado quando a animação termina
                        exibirPopup();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // Chamado quando a animação se repete (se necessário)
                    }
                });

                garrafa.startAnimation(girar);
            }
        });
    }

    private void exibirPopup() {
        View parentView = findViewById(android.R.id.content);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.mainpopup, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;

        popupWindow = new PopupWindow(popUpView, width, height, true);
        popupWindow.showAtLocation(parentView, Gravity.CENTER, 0, 0);

        CheckBox checkBoxDesafio = popUpView.findViewById(R.id.checkBoxDesafio);
        CheckBox checkBoxVerdade = popUpView.findViewById(R.id.checkBoxVerdade);

        checkBoxDesafio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, desafio.class);
                startActivity(intent);
                fecharPopup();
            }
        });

        checkBoxVerdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, verdade.class);
                startActivity(intent);
                fecharPopup();
            }
        });
    }

    private void fecharPopup() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }
}
