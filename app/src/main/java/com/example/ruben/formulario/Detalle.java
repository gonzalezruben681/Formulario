package com.example.ruben.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {
private TextView t1,t2,t3,t4,t5;
private Button editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        t1 = (TextView) findViewById(R.id.txNombre);
        t2 = (TextView) findViewById(R.id.txFecha);
        t3 = (TextView) findViewById(R.id.txTelefono);
        t4 = (TextView) findViewById(R.id.txEmail);
        t5 = (TextView) findViewById(R.id.txComentarios);
        editar = (Button) findViewById(R.id.btnEditar);

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
        t5.setText(comentario);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detalle.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre),t1.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha),t2.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono),t3.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail),t4.getText().toString());
                intent.putExtra(getResources().getString(R.string.comentarios),t5.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}