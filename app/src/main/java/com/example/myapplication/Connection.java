package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Connection extends SQLiteOpenHelper {

    //criar atributos com nome do banco, versao
    private static final String name = "banco.db";
    private static final int version = 1;

    public Connection(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table cliente(id integer primary key autoincrement, " + "nome varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}