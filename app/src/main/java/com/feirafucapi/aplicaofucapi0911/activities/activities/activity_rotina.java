package com.feirafucapi.aplicaofucapi0911.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.feirafucapi.aplicaofucapi0911.R;

public class activity_rotina extends AppCompatActivity {

    private ImageButton btnVoltar;
    private Button btnTerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotina);

        btnVoltar = findViewById(R.id.imgbVoltar);
        btnTerca = findViewById(R.id.btnTercaFeira);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_menu_principal.class);
                startActivity(intent);
            }
        });
        btnTerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), tercafeira_rotina.class);
                startActivity(intent);
            }
        });
    }
}