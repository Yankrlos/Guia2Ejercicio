package com.example.guia2ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    EditText edtcorreo, edtcontraseña;
    Button btnsesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtcorreo = findViewById(R.id.edtcorreo);
        edtcontraseña = findViewById(R.id.edtcontraseña);

        btnsesion = findViewById(R.id.btnsesion);

        btnsesion.setOnLongClickListener(this);
    }


    @Override
    public boolean onLongClick(View view) {
        switch(view.getId()){
            case R.id.btnsesion:{
                String correo = edtcorreo.getText().toString();
                String contraseña = edtcontraseña.getText().toString();

                if(edtcorreo.getText().toString().isEmpty()){
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "El campos de correo estan vacio", Toast.LENGTH_SHORT);

                    toast1.show();
                }else if( edtcontraseña.getText().toString().isEmpty()){
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "El campos de contraseña estan vacio", Toast.LENGTH_SHORT);

                    toast1.show();
                }
                else{
                    Intent in = new Intent(this, Favorito.class);
                    startActivity(in);
                }
            }
            break;
        }
        return false;
    }
}
