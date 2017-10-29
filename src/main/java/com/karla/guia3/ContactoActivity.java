package com.karla.guia3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Karla on 22/09/2017.
 */

public class ContactoActivity extends AppCompatActivity {
    //declaracion de variables
    private EditText txtNombre,txtNumero;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


        //inicializando variables
        txtNombre   = (EditText) findViewById(R.id.txtNombre);
        txtNumero   = (EditText) findViewById(R.id.txtNumero);
        btnAgregar  = (Button  ) findViewById(R.id.btnAgregarContacto);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtNombre.getText().toString().isEmpty() || txtNumero.getText().toString().isEmpty() ){
                    Toast.makeText(ContactoActivity.this,"Inserta los datos del contacto",Toast.LENGTH_SHORT).show();
                }else{

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("NOMBRE",txtNombre.getText().toString());
                    resultIntent.putExtra("NUMERO",txtNumero.getText().toString());
                    setResult(Principal.GUARDADO, resultIntent);
                    finish();
                }
            }
        });
    }
}
