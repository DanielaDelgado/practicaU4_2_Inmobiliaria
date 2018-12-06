package com.example.danielamarcela.practicau4_2_inmobiliaria;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {


    //perdon por el codigo feo pero intente arreglarlo y ya no me dejaba hacer nada y no se que paso que tampoco me deja
    //ingresar los datos de inmueble
    //se que no tiene que ver pero hice lo mejor que pude... Android no ayudo profe :c
    EditText idpropietario,nombre,direp,telefonop;
    Button consupro;
    EditText idinmueble,dominmueble,pventa,prenta,fecha;
    Button consuinmueble;

    BaseDatos basee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        idpropietario=findViewById(R.id.idenpropi);
        nombre=findViewById(R.id.nombre);
        direp=findViewById(R.id.direccionp);
        telefonop=findViewById(R.id.telefonop);

        consupro=findViewById(R.id.consupro);

        idinmueble=findViewById(R.id.ideninmo);
        dominmueble=findViewById(R.id.domicilioi);
        pventa=findViewById(R.id.precioventa);
        prenta=findViewById(R.id.preciorenta);
        fecha=findViewById(R.id.fecha);

        consuinmueble=findViewById(R.id.consuin);


        basee = new BaseDatos(this,"primera",null,1);
        
        consupro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarPropietario();
            }
        });

        consuinmueble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //consultarInmueble();
            }
        });
    }

    private void consultarPropietario() {

        pedirID(1);
    }

    private void pedirID(final int origen)
    {
        final EditText pidoID = new EditText(this);
        pidoID.setInputType(InputType.TYPE_CLASS_NUMBER);
        pidoID.setHint("Valor entero mayor de 0");
        String mensaje ="Escriba el id a buscar";

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);


        alerta.setTitle("atencion").setMessage(mensaje)
                .setView(pidoID)
                .setPositiveButton("Buscar", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        if(pidoID.getText().toString().isEmpty())
                        {
                            Toast.makeText(Main4Activity.this,"Debes escribir un numero",Toast.LENGTH_LONG).show();
                            return;
                        }
                        buscarDato(pidoID.getText().toString(), origen);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar",null).show();
    }

    private void buscarDato(String idABuscar, int origen)
    {
        try{

            SQLiteDatabase tabla = basee.getReadableDatabase();

            String SQL = "SELECT *FROM PROPIETARIO WHERE ID="+idABuscar;

            Cursor resultado = tabla.rawQuery(SQL,null);

            if(resultado.moveToFirst())
            {
                if(origen==3)
                {
                    String dato = idABuscar+"&"+ resultado.getString(1)+"&"+resultado.getString(2)+
                            "&"+resultado.getString(3)+"&"+resultado.getString(4);
                    return;
                }

                idpropietario.setText(resultado.getString(0));
                nombre.setText(resultado.getString(1));
                direp.setText(resultado.getString(2));
                telefonop.setText(resultado.getString(3));

            }
            else
            {
                Toast.makeText(this,"No se encontro resultado",Toast.LENGTH_LONG).show();
            }
            tabla.close();

        }catch (SQLiteException e)
        {
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }

}
