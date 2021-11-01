package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    Button sbt;
    EditText etx;
    String user_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        sbt = findViewById(R.id.start_bt);
        etx = findViewById(R.id.et_name);
        user_Name = etx.getText().toString();

        sbt.setOnClickListener(v -> {
            if(etx.getText().toString().isEmpty()) {
                //MENSAJE EN PANTALLA QUE INDIQUE QUE AUN TIENES QUE RELLENAR EL CAMPO
                Toast.makeText(getApplicationContext(), "Introduce un nombre por favor", Toast.LENGTH_SHORT).show();
            }else{
                //CAMBIA DE ACTIVITY
                Intent jugar = new Intent(MainMenu.this, MainActivity.class);
                jugar.putExtra("Nombre", etx.getText().toString());
                startActivity(jugar);
            }
        });
    }
}