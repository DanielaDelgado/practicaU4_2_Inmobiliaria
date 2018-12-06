package com.example.danielamarcela.practicau4_2_inmobiliaria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PROPIETARIO(IDP INTEGER  PRIMARY KEY, NOMBRE VARCHAR(200), DOMICILIO VARCHAR(500),TELEFONO VARCHAR(50))");
        db.execSQL("CREATE TABLE INMUEBLE(IDINMUEBLE INTEGER PRIMARY KEY, DOMICILIO VARCHAR(200),PRECIOVENTA FLOAT, PRECIORENTA FLOAT, FECHATRANSACCION DATE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
