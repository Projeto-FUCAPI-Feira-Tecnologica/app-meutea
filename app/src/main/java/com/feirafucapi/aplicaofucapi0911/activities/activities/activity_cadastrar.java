package com.feirafucapi.aplicaofucapi0911.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.feirafucapi.aplicaofucapi0911.R;
import com.feirafucapi.aplicaofucapi0911.activities.helper.DBHelperUserCadastro;

public class activity_cadastrar extends AppCompatActivity {

    private Button btnCadastrar;
    private SQLiteDatabase bancoDadosUser;
    private EditText campoNome, campoEmail, campoSenha;
    private ImageButton ibCad;
    private DBHelperUserCadastro dbHelperUserCadastro;

    DBHelperUserCadastro dbTea = new DBHelperUserCadastro(this); // Criação do objeto referente ao banco de dados
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        campoNome = findViewById(R.id.campoNome);
        campoEmail = findViewById(R.id.campoEmail);
        campoSenha = findViewById(R.id.campoSenha);
        dbHelperUserCadastro = new DBHelperUserCadastro(this);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        ibCad = findViewById(R.id.imgBtnCad);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome, email, senha;
                nome = campoNome.getText().toString();
                email = campoEmail.getText().toString();
                senha = campoSenha.getText().toString();

                if(nome.equals("") || email.equals("") || senha.equals("")){
                    Toast.makeText(activity_cadastrar.this, "Preencha todos os campos corretamente.", Toast.LENGTH_LONG).show();
                }else{
                    if(dbHelperUserCadastro.checarNome(nome)){
                        Toast.makeText(activity_cadastrar.this, "Usuário já existe!", Toast.LENGTH_LONG).show();
                        return;
                    }

                    boolean registradoSucesso = dbHelperUserCadastro.inserirDados(nome, email, senha);

                    if(registradoSucesso){
                        Toast.makeText(activity_cadastrar.this, "Usuário Registrado COM SUCESSO!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), activity_login.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }else{
                        Toast.makeText(activity_cadastrar.this, "Falha ao registrar o usuário.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        ibCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_login.class);
                startActivity(intent);
            }
        });

    }

    public void criarBancoDados() {

        try {
            bancoDadosUser = openOrCreateDatabase("cruduser", MODE_PRIVATE, null);
            bancoDadosUser.execSQL("CREATE TABLE IF NOT EXISTS user("
                    +"id INTEGER PRIMARY KEY AUTOINCREMENT"
                    +", nomeUser VARCHAR"
                    +", emailUser VARCHAR"
                    +", passwordUser VARCHAR)");
            bancoDadosUser.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cadastrar(){

        try {
            bancoDadosUser = openOrCreateDatabase("cruduser", MODE_PRIVATE, null);
            if(!TextUtils.isEmpty(campoNome.getText().toString())){
                if(!TextUtils.isEmpty(campoEmail.getText().toString())){
                    if( !TextUtils.isEmpty(campoSenha.getText().toString())){
                        String sql = "INSERT INTO user (nomeUser, emailUser, passwordUser) VALUES (?, ?, ?)";
                        SQLiteStatement stmt = bancoDadosUser.compileStatement(sql);
                        stmt.bindString(1, campoNome.getText().toString());
                        stmt.bindString(1, campoEmail.getText().toString());
                        stmt.bindString(1, campoSenha.getText().toString());

                        stmt.executeInsert();
                        bancoDadosUser.close();
                        finish();
                    }
                }
            }
            bancoDadosUser.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}