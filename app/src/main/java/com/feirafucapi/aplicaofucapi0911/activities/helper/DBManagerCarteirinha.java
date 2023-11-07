package com.feirafucapi.aplicaofucapi0911.activities.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManagerCarteirinha {
    private Context context;
    private SQLiteDatabase database;
    private DBHelperCarteirinhaDigital dbHelper;

    public DBManagerCarteirinha(Context c) {
        this.context = c;
    }

    public DBManagerCarteirinha open() throws SQLException {
        this.dbHelper = new DBHelperCarteirinhaDigital(this.context);
        this.database = this.dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        this.dbHelper.close();
    }

    public void insert(String nome,String cid, String rg, String tipo, String cpf, String contato, String nacionalidade) {
        ContentValues cv = new ContentValues();
        cv.put(DBHelperCarteirinhaDigital.NOME, nome);
        cv.put(DBHelperCarteirinhaDigital.CID, cid);
        cv.put(DBHelperCarteirinhaDigital.RG, rg);
        cv.put(DBHelperCarteirinhaDigital.TIPO, tipo);
        cv.put(DBHelperCarteirinhaDigital.CPF, cpf);
        cv.put(DBHelperCarteirinhaDigital.CONTATO, contato);
        cv.put(DBHelperCarteirinhaDigital.NACIONALIDADE, nacionalidade);

        this.database.insert(DBHelperCarteirinhaDigital.TABELA_NOME, null, cv);
    }

    public Cursor fetch(){
        Cursor cursor = this.database.query(DBHelperCarteirinhaDigital.TABELA_NOME, new String[]{DBHelperCarteirinhaDigital.NOME, DBHelperCarteirinhaDigital.CID, DBHelperCarteirinhaDigital.RG, DBHelperCarteirinhaDigital.TIPO, DBHelperCarteirinhaDigital.CPF, DBHelperCarteirinhaDigital.CONTATO,DBHelperCarteirinhaDigital.NACIONALIDADE}, null, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }


}
