package com.example.guia2ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Favorito extends AppCompatActivity implements View.OnClickListener {

    ProgressBar pbarfavoritos;
    Button btnprocesar;
    AutoCompleteTextView Actfruta, ActAnimal, Actlenguaje;
    String [] fruta ={"Manzana","Naranja","Uva", "Banana"};
    String [] animal ={"León", "Jirafa", "Oso", "Tigre"};
    String [] lenguaje ={"C++","C#","PHP","Python", "Java", "JavaScript"};
    TextView porcentaje;
    String mensaje =" Opciones Seleccionadas: ";
    private int mProgressStatus = 0;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        Actfruta = findViewById(R.id.Actfruta);
        ActAnimal = findViewById(R.id.ActAnimal);
        Actlenguaje = findViewById(R.id.Actlenguaje);

        ArrayAdapter<String> adapterf = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, fruta);

        Actfruta.setThreshold(1);
        Actfruta.setAdapter(adapterf);

        ArrayAdapter<String> adaptera = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, animal);

        ActAnimal.setThreshold(1);
        ActAnimal.setAdapter(adaptera);

        ArrayAdapter<String> adapterl = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, lenguaje);

        Actlenguaje.setThreshold(1);
        Actlenguaje.setAdapter(adapterl);

        pbarfavoritos = findViewById(R.id.pbarfavoritos);
        btnprocesar = findViewById(R.id.btnprocesar);
        porcentaje=findViewById(R.id.porcentaje);

        btnprocesar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnprocesar: {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (mProgressStatus < 100){
                            mProgressStatus++;
                            android.os.SystemClock.sleep(50);
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    pbarfavoritos.setProgress(mProgressStatus);
                                    porcentaje.setText(mProgressStatus + " %");
                                }
                            });
                        }
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(Favorito.this,mensaje+"\n"
                                        + Actfruta.getText().toString()+"\n"
                                        + ActAnimal.getText().toString()+"\n"
                                        + Actlenguaje.getText().toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).start();
            }
            break;
        }
    }
}
