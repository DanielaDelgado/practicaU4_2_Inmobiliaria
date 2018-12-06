package com.example.danielamarcela.practicau4_2_inmobiliaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button darDeAlta,consultar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        darDeAlta=findViewById(R.id.daralta);
        consultar=findViewById(R.id.consultar);

        darDeAlta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ventanaAlta=new Intent(MainActivity.this, Main2Activity.class);
                startActivity(ventanaAlta);

            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent ventanaC=new Intent(MainActivity.this, Main4Activity.class);
                startActivity(ventanaC);

            }
        });
    }
}
