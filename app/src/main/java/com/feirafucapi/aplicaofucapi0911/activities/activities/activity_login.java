package com.feirafucapi.aplicaofucapi0911.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.helper.DBHelper;

public class activity_login extends AppCompatActivity {

    private TextView textCadastre;
    private EditText campoemail;
    private EditText camposenha;
    private Button buttonContinuar;
    private ImageButton buttonVoltar;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoemail = findViewById(R.id.editEmail);
        camposenha = findViewById(R.id.editSenha);
        textCadastre = findViewById(R.id.txtVCadastrar);
        buttonContinuar = findViewById(R.id.btnContinuar);
        buttonVoltar = findViewById(R.id.btnVoltar);
        dbHelper = new DBHelper(this);

        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean logadoID = dbHelper.checarUsuario(campoemail.getText().toString(), camposenha.getText().toString());
                if(logadoID)
                {
                    Intent intent = new Intent(getApplicationContext(), activity_menu_principal.class);
                    startActivity(intent);
                    Toast.makeText(activity_login.this, "Logado com SUCESSO!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(activity_login.this, "Falha no Login", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void cadastrar(View view){
        textCadastre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_cadastrar.class);
                startActivity(intent);
            }
        });
    }


}