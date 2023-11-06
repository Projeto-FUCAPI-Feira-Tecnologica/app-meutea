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
        DB = new DBHelperCarteirinhaDigital(this);

        Cursor cursor = DB.pegarTextos();

        // Verifique se o cursor não é nulo
        if (cursor != null && cursor.moveToFirst()) {
            // Obtenha os valores das colunas do cursor
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String cid = cursor.getString(cursor.getColumnIndex("cid"));
            String rg = cursor.getString(cursor.getColumnIndex("rg"));
            String tipo = cursor.getString(cursor.getColumnIndex("tipo"));
            String cpf = cursor.getString(cursor.getColumnIndex("cpf"));
            String contato = cursor.getString(cursor.getColumnIndex("contato"));
            String nacionalidade = cursor.getString(cursor.getColumnIndex("nacionalidade"));

            // Defina os valores nas TextViews correspondentes
            txtNome.setText(nome);
            txtCID.setText(cid);
            txtRG.setText(rg);
            txtTipo.setText(tipo);
            txtCPF.setText(cpf);
            txtContato.setText(contato);
            txtNacionalidade.setText(nacionalidade);
        }

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