package com.feirafucapi.aplicaofucapi0911.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.helper.DBHelperUserCadastro;

public class activity_login extends AppCompatActivity {

    private EditText campoemail;
    private EditText camposenha;
    private Button buttonContinuar, buttonCadastrar;
    private ImageButton buttonVoltar;
    private DBHelperUserCadastro dbHelperUserCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoemail = findViewById(R.id.editEmail);
        camposenha = findViewById(R.id.editSenha);
        buttonCadastrar = findViewById(R.id.btnCadastrar);
        buttonContinuar = findViewById(R.id.btnContinuar);
        buttonVoltar = findViewById(R.id.btnVoltar);
        dbHelperUserCadastro = new DBHelperUserCadastro(this);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_cadastrar.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean logadoID = dbHelperUserCadastro.checarUsuario(campoemail.getText().toString(), camposenha.getText().toString());
                if (campoemail.getText().toString().equals("") || camposenha.getText().toString().equals("")) {
                    Toast.makeText(activity_login.this, "Insira os campos corretamente.", Toast.LENGTH_LONG).show();
                } else {
                    if (logadoID) {
                        Intent intent = new Intent(getApplicationContext(), activity_menu_principal.class);
                        Toast.makeText(activity_login.this, "Logado com SUCESSO!", Toast.LENGTH_SHORT).show();
                        /*nomecadastrado = dbHelper.pegarNome(campoemail.getText().toString(), camposenha.getText().toString());
                        intent.putExtra("NAME", nomecadastrado.toString());*/
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(activity_login.this, "Falha no Login", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_bemvindo1.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

    }
}