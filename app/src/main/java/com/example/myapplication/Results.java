package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    TextView Nombre, Puntuacion;
    String nombre, puntuacion;
    Button rbt, fbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Nombre = (TextView) findViewById(R.id.su_nombre);
        Puntuacion = (TextView) findViewById(R.id.et_puntuacion);
        rbt = findViewById(R.id.restart_bt);
        fbt = findViewById(R.id.final_bt);

        Bundle bundle = this.getIntent().getExtras();

        nombre = bundle.getString("Nombre");
        puntuacion = "" + bundle.getInt("Puntuacion");

        Nombre.setText("Nombre: " + nombre);
        Puntuacion.setText("Puntuacion: " + puntuacion);

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