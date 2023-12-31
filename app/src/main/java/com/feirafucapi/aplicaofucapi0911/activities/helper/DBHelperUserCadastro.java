package com.feirafucapi.aplicaofucapi0911.activities.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperUserCadastro extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MeuTea.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelperUserCadastro(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSQL = "CREATE TABLE Usuario (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "email TEXT, " +
                "senha TEXT)";
        db.execSQL(createTableSQL);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Usuario");
    }

    public boolean inserirDados(String nome, String email, String senha) { // Função para adicionar ao banco de dados dados inseridos no cadastrar
        SQLiteDatabase meuDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", nome);
        cv.put("email", email);
        cv.put("senha", senha);
        long result = meuDB.insert("Usuario", null, cv);

        if(result==-1) return false;
        else return true;
    }

    public boolean checarNome(String userName) { // Verificar se já nao tem um nome cadastrado no banco de dados ao cadastrar um novo
        SQLiteDatabase meuDB = this.getReadableDatabase();
        Cursor cursor = meuDB.rawQuery("SELECT * FROM Usuario WHERE nome = ?", new String[]{userName});
        return cursor.getCount() > 0;
    }

    public boolean checarUsuario(String useremail, String usersenha){
        SQLiteDatabase meuDB = this.getWritableDatabase();
        Cursor cursor = meuDB.rawQuery("SELECT * FROM Usuario WHERE email = ? and senha = ?", new String[]{useremail, usersenha});
        if(cursor.getCount() > 0)
            return true;
        else return false;

    }

}