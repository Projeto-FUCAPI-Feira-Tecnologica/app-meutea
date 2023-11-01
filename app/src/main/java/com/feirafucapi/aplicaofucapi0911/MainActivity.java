package com.feirafucapi.aplicaofucapi0911;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textCadastre;
    private EditText campoemail;
    private EditText camposenha;
    private Button buttonContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoemail = findViewById(R.id.editEmail);
        camposenha = findViewById(R.id.editSenha);
        textCadastre = findViewById(R.id.txtVCadastrar);
        buttonContinuar = findViewById(R.id.btnContinuar);

        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_menu_principal.class);

                startActivity(intent);
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