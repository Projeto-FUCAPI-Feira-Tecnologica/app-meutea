package com.feirafucapi.aplicaofucapi0911.activities.activities.carteirinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.activities.principal.activity_menu_principal;
import com.feirafucapi.aplicaofucapi0911.activities.helper.DBHelperCarteirinhaDigital;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_carteirinha_digital extends AppCompatActivity {

    private ImageButton btnVoltar;
    private TextView txtNome, txtCID, txtRG, txtTipo, txtCPF, txtContato, txtNacionalidade;
    private FloatingActionButton fabAdd, fabEdit;
    private DBHelperCarteirinhaDigital DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteirinha_digital);

        btnVoltar = findViewById(R.id.btnVoltarCarteirinha);
        fabAdd = findViewById(R.id.fabAddCarteirinha);
        fabEdit = findViewById(R.id.fabEditCarteirinha);
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
            fabEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nome = txtNome.getText().toString();
                    String cid = txtCID.getText().toString();
                    String rg = txtRG.getText().toString();
                    String tipo = txtTipo.getText().toString();
                    String cpf = txtCPF.getText().toString();
                    String contato = txtContato.getText().toString();
                    String nacionalidade = txtNacionalidade.getText().toString();

                    Intent intent = new Intent(getApplicationContext(), activity_edit_carteirinha.class);

                    intent.putExtra("nome", nome);
                    intent.putExtra("cid", cid);
                    intent.putExtra("rg", rg);
                    intent.putExtra("tipo", tipo);
                    intent.putExtra("cpf", cpf);
                    intent.putExtra("contato", contato);
                    intent.putExtra("nacionalidade", nacionalidade);

                    if (nome.equals("") || cid.equals("") | rg.equals("") || tipo.equals("") || cpf.equals("") || contato.equals("") || nacionalidade.equals("")) {
                        Toast.makeText(getApplicationContext(), "Preencha as informações para poder editar!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(activity_carteirinha_digital.this, "Faça suas alterações!", Toast.LENGTH_SHORT).show();
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
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


    @Override
    protected void onResume() {
        super.onResume();

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
    }
}