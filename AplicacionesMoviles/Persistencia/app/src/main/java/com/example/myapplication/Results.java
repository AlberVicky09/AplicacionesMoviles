package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    TextView Nombre, Puntuacion, Rank1;
    String nombre, puntuacion, rn1;
    int points,rp1;
    Button rbt, fbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_results);
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor miEditor = datos.edit();
        Rank1 = (TextView) findViewById(R.id.r1);

        Nombre = (TextView) findViewById(R.id.su_nombre);
        //Puntuacion = (TextView) findViewById(R.id.et_puntuacion);
        rbt = findViewById(R.id.restart_bt);
        fbt = findViewById(R.id.final_bt);

        Bundle bundle = this.getIntent().getExtras();

        nombre = bundle.getString("Nombre");
        puntuacion = "" + bundle.getInt("Puntuacion");

        rn1 = datos.getString("NombreR1","Primero");
        rp1 = datos.getInt("PuntosR1",0);
        points = bundle.getInt("Puntuacion");
        if(points>rp1) {
            miEditor.putString("NombreR1", nombre);
            miEditor.putInt("PuntosR1", points);
        }
        miEditor.apply();


        //Nombre.setText("Nombre: " + nombre);
        Nombre.setText(nombre + ": " + puntuacion + " ptos.");
        //Puntuacion.setText("Puntuacion: " + puntuacion);

        /*rn1 = datos.getString("NombreR1","Primero");
        rp1 = datos.getInt("PuntosR1",0);*/
        Rank1.setText(rn1 + ": " + rp1 + " ptos.");

        rbt.setOnClickListener(v -> {
            Intent rejugar = new Intent(Results.this, MainActivity.class);
            startActivity(rejugar);
        });
        fbt.setOnClickListener(v -> {
            Intent inicio = new Intent(Results.this, MainMenu.class);
            startActivity(inicio);
        });
    }
}