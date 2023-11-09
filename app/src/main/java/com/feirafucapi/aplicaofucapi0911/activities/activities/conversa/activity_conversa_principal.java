package com.feirafucapi.aplicaofucapi0911.activities.activities.conversa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.activities.principal.activity_menu_principal;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.tercafeira.activity_tercafeira_rotina_tarde;

public class activity_conversa_principal extends AppCompatActivity {

    private ImageButton btnVoltar;
    private CardView cardViewEmocoes, cardViewEmCasa, cardViewNecessidade, cardViewComidas, cardViewDor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversa_principal);

        btnVoltar = findViewById(R.id.btnVoltarConversa);
        cardViewEmocoes = findViewById(R.id.cardViewEmocoes);
        cardViewEmCasa = findViewById(R.id.cardViewEmCasa);
        cardViewNecessidade = findViewById(R.id.cardViewNecessidades);
        cardViewComidas = findViewById(R.id.cardViewComidas);
        cardViewDor = findViewById(R.id.cardViewDor);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_menu_principal.class);
                startActivity(intent);
            }
        });

        cardViewEmocoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_conversa_emocoes.class);;
                startActivity(intent);
            }
        });

        cardViewDor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_conversa_dor.class);;
                startActivity(intent);
            }
        });

        cardViewComidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_conversa_comidas.class);;
                startActivity(intent);
            }
        });

        cardViewEmCasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_conversa_emcasa.class);
                startActivity(intent);
            }
        });

        cardViewNecessidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_conversa_necessidade.class);
                startActivity(intent);
            }
        });
    }
}