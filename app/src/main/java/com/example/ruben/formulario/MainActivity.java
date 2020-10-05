package com.example.ruben.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private TextInputEditText t1,t2,t3,t4,comentarios;
    private Button bfecha,siguente;
    private int dia,mes,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bfecha = (Button) findViewById(R.id.bfecha);
        siguente =(Button) findViewById(R.id.siguente);
        t1 = (TextInputEditText) findViewById(R.id.txtNombre);
        t2 = (TextInputEditText) findViewById(R.id.txtFecha);
        t3 = (TextInputEditText) findViewById(R.id.txtTelefono);
        t4 = (TextInputEditText) findViewById(R.id.txtEmail);
        comentarios = (TextInputEditText) findViewById(R.id.comentarios);

        Bundle parametros = getIntent().getExtras(); // Para enviar datos entre activies se hace uso de la clase Bundle
        String nombre = parametros.getString(getResources().getString(R.string.pnombre)); // nombre
        String fecha = parametros.getString(getResources().getString(R.string.pfecha)); // fecha nacimiento
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono)); // telefono
        String email = parametros.getString(getResources().getString(R.string.pemail));// email
        String comentario = parametros.getString(getResources().getString(R.string.comentarios)); //comentarios

        t1.setText(nombre);
        t2.setText(fecha);
        t3.setText(telefono);
        t4.setText(email);
        comentarios.setText(comentario);


        bfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    // instancia de la clase calendar
                    final Calendar c = Calendar.getInstance();
                    year = c.get(Calendar.YEAR); //
                    mes = c.get(Calendar.MONTH); //
                    dia = c.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                            t2.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                        }
                    },dia,mes,year);
                    datePickerDialog.show();
            }
        });

        siguente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Detalle.class);
                //para almacenar los datos para asi enviarlos
                intent.putExtra(getResources().getString(R.string.pnombre),t1.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha),t2.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono),t3.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail),t4.getText().toString());
                intent.putExtra(getResources().getString(R.string.comentarios),comentarios.getText().toString());

                startActivity(intent);
                finish();

            }
        });

    }
}



