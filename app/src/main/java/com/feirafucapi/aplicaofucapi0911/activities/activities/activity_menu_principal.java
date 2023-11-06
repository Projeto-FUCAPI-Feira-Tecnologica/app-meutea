package com.feirafucapi.aplicaofucapi0911.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.activities.rotina.activity_rotina;
import com.feirafucapi.aplicaofucapi0911.activities.helper.DBHelperUserCadastro;

public class activity_menu_principal extends AppCompatActivity {

    private Button botaoRotina;
    private Button botaoCarteirinha;
    private DBHelperUserCadastro dbHelperUserCadastro;
    private Cursor nome;
    private TextView bemvindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        botaoRotina = findViewById(R.id.btnRotina);
        botaoCarteirinha = findViewById(R.id.btnCarteirinha);
        bemvindo = findViewById(R.id.textViewBemVindo);

        dbHelperUserCadastro = new DBHelperUserCadastro(this);

        /*Intent intent = getIntent();
        String nome = intent.getStringExtra("NAME");

        bemvindo.setText("Bem-vindo, "+nome.toString());*/

        botaoRotina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_rotina.class);
                startActivity(intent);
            }
        });

        botaoCarteirinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_carteirinha_digital.class);
                startActivity(intent);
            }
        });

    }
}