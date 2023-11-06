package com.feirafucapi.aplicaofucapi0911.activities.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperCarteirinhaDigital extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MeuteaCarteirinha.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelperCarteirinhaDigital(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSQL = "CREATE TABLE Carteira (" +
                "nome TEXT, " +
                "cid TEXT, " +
                "rg TEXT, " +
                "tipo TEXT, " +
                "cpf TEXT, " +
                "contato TEXT, " +
                "nacionalidade TEXT)";

        db.execSQL(createTableSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists Carteira");

    }

    public boolean inserirDadosCarteirinha(String nome,String cid, String rg, String tipo, String cpf, String contato, String nacionalidade) {
        SQLiteDatabase meuDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", nome);
        cv.put("cid", cid);
        cv.put("rg", rg);
        cv.put("tipo", tipo);
        cv.put("cpf", cpf);
        cv.put("contato", contato);
        cv.put("nacionalidade", nacionalidade);

        long result = meuDB.insert("Carteira", null, cv);
        if(result==-1) return false;
        else return true;
    }

    public Cursor pegarTextos(){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM Carteira", null);
        return cursor;
    }
}
