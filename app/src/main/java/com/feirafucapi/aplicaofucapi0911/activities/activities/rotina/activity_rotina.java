package com.feirafucapi.aplicaofucapi0911.activities.activities.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.activities.principal.activity_menu_principal;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.domingo.activity_domingo_rotina_manha;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.quartafeira.activity_quartafeira_rotina_manha;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.quintafeira.activity_quintafeira_rotina_manha;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.sabado.activity_sabado_rotina_manha;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.segundafeira.activity_segundafeira_rotina_manha;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.sextafeira.activity_sextafeira_rotina_manha;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.tercafeira.activity_tercafeira_rotina_manha;

public class activity_rotina extends AppCompatActivity {

    private ImageButton btnVoltar;
    private Button btnSegunda, btnTerca, btnQuarta, btnQuinta, btnSexta, btnSabado, btnDomingo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotina);

        btnVoltar = findViewById(R.id.imgbVoltar);
        btnSegunda = findViewById(R.id.btnSegundaFeira);
        btnTerca = findViewById(R.id.btnTercaFeira);
        btnQuarta = findViewById(R.id.btnQuartaFeira);
        btnQuinta = findViewById(R.id.btnQuintaFeira);
        btnSexta = findViewById(R.id.btnSextaFeira);
        btnSabado = findViewById(R.id.btnSabado);
        btnDomingo = findViewById(R.id.btnDomingo);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_menu_principal.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        btnSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_segundafeira_rotina_manha.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        btnTerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_tercafeira_rotina_manha.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        btnQuarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_quartafeira_rotina_manha.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        btnQuinta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_quintafeira_rotina_manha.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        btnSexta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_sextafeira_rotina_manha.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        btnSabado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_sabado_rotina_manha.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        btnDomingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_domingo_rotina_manha.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });


    }
}