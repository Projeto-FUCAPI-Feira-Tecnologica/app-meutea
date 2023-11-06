package com.feirafucapi.aplicaofucapi0911.activities.activities.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.activities.activity_menu_principal;

public class activity_rotina extends AppCompatActivity {

    private ImageButton btnVoltar;
    private Button btnSegunda, btnTerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotina);

        btnVoltar = findViewById(R.id.imgbVoltar);
        btnSegunda = findViewById(R.id.btnSegundaFeira);
        btnTerca = findViewById(R.id.btnTercaFeira);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_menu_principal.class);
                startActivity(intent);
            }
        });
        btnSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_segundafeira_rotina.class);
                startActivity(intent);
            }
        });

        btnTerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_tercafeira_rotina.class);
                startActivity(intent);
            }
        });
    }
}