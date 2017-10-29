package com.karla.guia3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    public static int GUARDADO=50;
    private AdaptadorContacto adaptadorContacto;
    private FloatingActionButton btnAgregar;
    private ArrayList<Contacto> contactosArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnAgregar  = (FloatingActionButton) findViewById(R.id.btnAgregar);
        contactosArrayList = new ArrayList<>();

        //Inicializando el adaptador
        adaptadorContacto = new AdaptadorContacto(this,  contactosArrayList);

        //Inicializando el listView
        ListView listView = (ListView) findViewById(R.id.lstContactos);

        listView.setAdapter(adaptadorContacto);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Principal.this,ContactoActivity.class);
                startActivityForResult(intent,GUARDADO);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mensajes=new Intent(Principal.this,MensajeActivity.class);
                startActivity(mensajes);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GUARDADO){
            if(data==null) return;
            //recibo el dato
            Contacto c = new Contacto(
                    data.getStringExtra("NOMBRE"),
                    data.getStringExtra("NUMERO")
            );
            contactosArrayList.add(c);
            adaptadorContacto.notifyDataSetChanged();
        }
    }
}
