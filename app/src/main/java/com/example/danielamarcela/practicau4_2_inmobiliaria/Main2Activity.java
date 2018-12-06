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

public class Main2Activity extends AppCompatActivity {
    EditText identificacion,nombre,direccionp,telefonop;
    Button alta,altain;
    BaseDatos base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        identificacion=findViewById(R.id.identificacion);
        nombre=findViewById(R.id.nombre);
        direccionp=findViewById(R.id.direccionp);
        telefonop=findViewById(R.id.telefonop);

        alta=findViewById(R.id.alta);
        altain=findViewById(R.id.altain);

        altain.setEnabled(false);

        base = new BaseDatos(this,"primera",null,1);

        alta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertar();

            }
        });

        altain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventanaAlta=new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(ventanaAlta);
            }
        });
    }

    private void insertar() {

        try
        {

            SQLiteDatabase tabla = base.getWritableDatabase();

            String SQL = "INSERT INTO PROPIETARIO VALUES(1,'%2','%3','%4')";
            SQL = SQL.replace("1", identificacion.getText().toString());
            SQL = SQL.replace("%2", nombre.getText().toString());
            SQL = SQL.replace("%3", direccionp.getText().toString());
            SQL = SQL.replace("%4", telefonop.getText().toString());
            tabla.execSQL(SQL);
            tabla.close();

            Toast.makeText( this,"Se ha guardado",Toast.LENGTH_LONG).show();
            altain.setEnabled(true);

        }catch (SQLiteException e)
        {
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
