package com.example.danielamarcela.practicau4_2_inmobiliaria;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    EditText identificador, domicilio,pventa,prenta, fecha;
    Button alta,principal;
    BaseDatos basee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        identificador=findViewById(R.id.identificacion);
        domicilio=findViewById(R.id.domicilioi);
        pventa=findViewById(R.id.precioventa);
        prenta=findViewById(R.id.preciorenta);
        fecha=findViewById(R.id.fecha);

        alta=findViewById(R.id.altain);
        principal=findViewById(R.id.principal);

        principal.setEnabled(false);

        basee = new BaseDatos(this,"primera",null,1);

        alta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daralta();
            }
        });
        principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventanaAlta=new Intent(Main3Activity.this, MainActivity.class);
                startActivity(ventanaAlta);

            }
        });
    }

    private void daralta() {
        try{

            SQLiteDatabase tabla = basee.getWritableDatabase();

            String SQL = "INSERT INTO INMUEBLE VALUES(1,'%2',3,4,5)";
            SQL = SQL.replace("1", identificador.getText().toString());
            SQL = SQL.replace("%2", domicilio.getText().toString());
            SQL = SQL.replace("3", pventa.getText().toString());
            SQL = SQL.replace("4", prenta.getText().toString());
            SQL = SQL.replace("5", fecha.getText().toString());
            tabla.execSQL(SQL);
            tabla.close();

            Toast.makeText( this,"Se ha guardado",Toast.LENGTH_LONG).show();
            identificador.setEnabled(false);
            domicilio.setEnabled(false);
            pventa.setEnabled(false);
            prenta.setEnabled(false);
            fecha.setEnabled(false);

            principal.setEnabled(true);

        }catch (SQLiteException e)
        {
            Toast.makeText(this,"No se pudo guardar",Toast.LENGTH_LONG).show();
        }
    }
}
