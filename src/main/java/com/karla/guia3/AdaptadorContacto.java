package com.karla.guia3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorContacto extends ArrayAdapter<Contacto>{

    public AdaptadorContacto(@NonNull Context context, @NonNull List<Contacto> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtener el dato
        Contacto contacto = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contacto, parent, false);
        }
        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
        TextView lblNumero = (TextView) convertView.findViewById(R.id.lblNumero);

        lblNombre.setText(contacto.nombre);
        lblNumero.setText(contacto.numero);


        return convertView;
    }
}
