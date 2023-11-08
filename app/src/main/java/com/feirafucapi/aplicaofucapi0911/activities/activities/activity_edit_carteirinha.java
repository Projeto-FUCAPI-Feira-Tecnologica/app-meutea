package com.feirafucapi.aplicaofucapi0911.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.feirafucapi.aplicaofucapi0911.R;

public class activity_edit_carteirinha extends AppCompatActivity {

    private EditText editNome, editCID, editRG, editTipo, editCPF, editContato, editNacionalidade;
    private Button btnAlterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_carteirinha);

        btnAlterar = findViewById(R.id.btnAlterarInfo);

        editNome = findViewById(R.id.campoNomeedit);
        editCID = findViewById(R.id.campoCIDedit);
        editRG = findViewById(R.id.campoRGedit);
        editTipo = findViewById(R.id.campoTipoSanguineoedit);
        editCPF = findViewById(R.id.campoCPFedit);
        editContato = findViewById(R.id.campoContatoedit);
        editNacionalidade = findViewById(R.id.campoNacionalidadeedit);

        Intent intent = getIntent();

        String strnome = intent.getStringExtra("nome");
        String strcid = intent.getStringExtra("cid");
        String strrg = intent.getStringExtra("rg");
        String strtipo = intent.getStringExtra("tipo");
        String strcpf = intent.getStringExtra("cpf");
        String strcontato = intent.getStringExtra("contato");
        String strnacionalidade = intent.getStringExtra("nacionalidade");

        editNome.setText(strnome);
        editCID.setText(strcid);
        editRG.setText(strrg);
        editTipo.setText(strtipo);
        editCPF.setText(strcpf);
        editContato.setText(strcontato);
        editNacionalidade.setText(strnacionalidade);

        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editNome.getText().toString();
                String cid = editCID.getText().toString();
                String rg = editRG.getText().toString();
                String tipo = editTipo.getText().toString();
                String cpf = editCPF.getText().toString();
                String contato = editContato.getText().toString();
                String nacionalidade = editNacionalidade.getText().toString();

                Intent intent = new Intent(getApplicationContext(), activity_carteirinha_digital.class);

                intent.putExtra("nome", nome);
                intent.putExtra("cid", cid);
                intent.putExtra("rg", rg);
                intent.putExtra("tipo", tipo);
                intent.putExtra("cpf", cpf);
                intent.putExtra("contato", contato);
                intent.putExtra("nacionalidade", nacionalidade);

                Toast.makeText(activity_edit_carteirinha.this, "Alterado com Sucesso!", Toast.LENGTH_SHORT).show();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}