package com.feirafucapi.aplicaofucapi0911.activities.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperCarteirinhaDigital extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MeuteaCarteirinha.db";
    private static final int DATABASE_VERSION = 1;
    public static final String NOME = "nome";
    public static final String CID = "cid";
    public static final String RG = "rg";
    public static final String TIPO = "tipo";
    public static final String CPF = "cpf";
    public static final String CONTATO = "contato";
    public static final String NACIONALIDADE = "nacionalidade";
    public static final String TABELA_NOME = "Carteira";


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

}
