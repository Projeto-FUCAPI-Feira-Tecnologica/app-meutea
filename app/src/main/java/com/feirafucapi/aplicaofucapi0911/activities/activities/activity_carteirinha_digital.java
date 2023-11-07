package com.feirafucapi.aplicaofucapi0911.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.helper.DBHelperCarteirinhaDigital;
import com.feirafucapi.aplicaofucapi0911.activities.helper.DBManagerCarteirinha;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_carteirinha_digital extends AppCompatActivity {

    private ImageButton btnVoltar;
    private TextView txtNome, txtCID, txtRG, txtTipo, txtCPF, txtContato, txtNacionalidade;
    private FloatingActionButton fabAdd;
    private DBHelperCarteirinhaDigital DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteirinha_digital);

        btnVoltar = findViewById(R.id.btnVoltarCarteirinha);
        fabAdd = findViewById(R.id.fabAddCarteirinha);
        txtNome = findViewById(R.id.tvNome);
        txtCID = findViewById(R.id.tvCID);
        txtRG = findViewById(R.id.tvRG);
        txtTipo = findViewById(R.id.tvTipo);
        txtCPF = findViewById(R.id.tvCPF);
        txtContato = findViewById(R.id.tvContato);
        txtNacionalidade = findViewById(R.id.tvNacionalidade);

        Intent intent = getIntent();

        String strnome = intent.getStringExtra("nome");
        String strcid = intent.getStringExtra("cid");
        String strrg = intent.getStringExtra("rg");
        String strtipo = intent.getStringExtra("tipo");
        String strcpf = intent.getStringExtra("cpf");
        String strcontato = intent.getStringExtra("contato");
        String strnacionalidade = intent.getStringExtra("nacionalidade");

        txtNome.setText(strnome);
        txtCID.setText(strcid);
        txtRG.setText(strrg);
        txtTipo.setText(strtipo);
        txtCPF.setText(strcpf);
        txtContato.setText(strcontato);
        txtNacionalidade.setText(strnacionalidade);



        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_crud_carteirinha.class);
                startActivity(intent);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_menu_principal.class);
                startActivity(intent);
            }
        });

    }

}