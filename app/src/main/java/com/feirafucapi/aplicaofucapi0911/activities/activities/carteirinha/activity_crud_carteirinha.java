package com.feirafucapi.aplicaofucapi0911.activities.activities.carteirinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.helper.DBHelperCarteirinhaDigital;
import com.feirafucapi.aplicaofucapi0911.activities.helper.DBManagerCarteirinha;

public class activity_crud_carteirinha extends AppCompatActivity {

    private Button btncadastrarInfo;
    private EditText campoNome, campoCID, campoRG, campoSanguineo, campoCPF, campoContato, campoNacionalidade;
    private DBHelperCarteirinhaDigital dbHelperCarteirinhaDigital;
    private DBManagerCarteirinha dbManagerCarteirinha;

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
                String nome = campoNome.getText().toString();
                String cid = campoCID.getText().toString();
                String rg = campoRG.getText().toString();
                String tipo = campoSanguineo.getText().toString();
                String cpf = campoCPF.getText().toString();
                String contato = campoContato.getText().toString();
                String nacionalidade = campoNacionalidade.getText().toString();

                Intent intent = new Intent(getApplicationContext(), activity_carteirinha_digital.class);

                intent.putExtra("nome", nome);
                intent.putExtra("cid", cid);
                intent.putExtra("rg", rg);
                intent.putExtra("tipo", tipo);
                intent.putExtra("cpf", cpf);
                intent.putExtra("contato", contato);
                intent.putExtra("nacionalidade", nacionalidade);

                Toast.makeText(activity_crud_carteirinha.this, "Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

    }
}