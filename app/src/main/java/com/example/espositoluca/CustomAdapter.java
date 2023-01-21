package com.example.espositoluca;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Persona> {
    LayoutInflater inflater;
    TextView nome;
    TextView valore;

    public CustomAdapter(Context context,int  resourceId, List<Persona> objects){
        super(context,resourceId,objects);
        inflater= LayoutInflater.from(context);
    }

    @Override
    public View getView(int position,View view,ViewGroup viewGroup) {
        if(view==null){
            view=inflater.inflate(R.layout.list_element,null);
        }

        Persona p=getItem(position);

        nome=view.findViewById(R.id.nomeElLista);
        valore=view.findViewById(R.id.numElLista);

        nome.setText(p.getNome());
        valore.setText(p.getVal()+"");

        return view;
    }
}
