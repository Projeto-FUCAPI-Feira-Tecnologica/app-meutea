package com.feirafucapi.aplicaofucapi0911.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.helper.DBHelper;

public class activity_cadastrar extends AppCompatActivity {

    private Button btnCadastrar;
    private ImageButton ibCad;

    DBHelper dbTea = new DBHelper(this); // Criação do objeto referente ao banco de dados
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        ibCad = findViewById(R.id.imgBtnCad);

        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText campoNome = findViewById(R.id.campoNome);
                EditText campoSenha = findViewById(R.id.campoSenha);
                EditText campoEmail = findViewById(R.id.campoEmail);

                String nome = campoNome.getText().toString();
                String senha = campoSenha.getText().toString();
                String email = campoEmail.getText().toString();

                SQLiteDatabase db = dbTea.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("nome", nome);
                values.put("senha", senha);
                values.put("email", email);

                long newRowId = db.insert("Usuario", null, values);

                // Verificando se foi bem-sucedida a inserção de dados no banco
                if(newRowId != -1) {
                    // O que vai acontecer se foi bem-sucedido
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else{
                    // Mensagem de erro quando não for bem sucedido
                }

                db.close();
            }
        });

        ibCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}