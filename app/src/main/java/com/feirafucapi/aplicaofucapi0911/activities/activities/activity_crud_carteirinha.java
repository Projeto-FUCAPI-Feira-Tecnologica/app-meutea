package com.feirafucapi.aplicaofucapi0911.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.helper.DBHelperCarteirinhaDigital;

public class activity_crud_carteirinha extends AppCompatActivity {

    private Button btncadastrarInfo;
    private TextView campoNome, campoCID, campoRG, campoSanguineo, campoCPF, campoContato, campoNacionalidade;
    private DBHelperCarteirinhaDigital dbHelperCarteirinhaDigital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_carteirinha);

        btncadastrarInfo = findViewById(R.id.btnCadastrarInfo);
        campoNome = findViewById(R.id.campoNome);
        campoCID = findViewById(R.id.campoCID);
        campoRG = findViewById(R.id.campoRG);
        campoSanguineo = findViewById(R.id.campoTipoSanguineo);
        campoCPF = findViewById(R.id.campoCPF);
        campoContato = findViewById(R.id.campoContato);
        campoNacionalidade = findViewById(R.id.campoNacionalidade);

        btncadastrarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome, cid, rg, tipo, cpf, contato, nacionalidade;
                nome = campoNome.getText().toString();
                cid = campoCID.getText().toString();
                rg = campoRG.getText().toString();
                tipo = campoSanguineo.getText().toString();
                cpf = campoCPF.getText().toString();
                contato = campoContato.getText().toString();
                nacionalidade = campoNacionalidade.getText().toString();

                if(nome.equals("") || cid.equals("") || rg.equals("") || tipo.equals("") || cpf.equals("") || contato.equals("") || nacionalidade.equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos corretamente.", Toast.LENGTH_LONG).show();
                }else{
                    boolean registradoSucesso = dbHelperCarteirinhaDigital.inserirDadosCarteirinha(nome, cid, rg, tipo, cpf, contato, nacionalidade);
                    if(registradoSucesso){
                        Toast.makeText(getApplicationContext(), "Sucesso ao cadastrar ROTINA!.", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Falha ao registrar a carteirinha.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}