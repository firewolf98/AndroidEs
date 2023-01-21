package com.example.espositoluca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    String nome;
    ArrayList<String> nomi;
    ArrayList<Integer> valori;
    int val;
    Button primAct;
    CustomAdapter customAdapter;
    ArrayList<Persona> persone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        primAct=findViewById(R.id.primAct);
        listView=findViewById(R.id.myListView);

        Intent i=getIntent();
        nome=i.getStringExtra("NOME");
        val=i.getIntExtra("VALORE",val);
        nomi=i.getStringArrayListExtra("NOMI");
        valori=i.getIntegerArrayListExtra("VALORI");
        Persona p=new Persona(nome,val);

        customAdapter=new CustomAdapter(this,R.id.myListView, new ArrayList<Persona>());
        listView.setAdapter(customAdapter);

        if(nomi!=null && valori!=null) {
            for(int k=0;k<nomi.size();k++){
                customAdapter.add(new Persona(nomi.get(k),valori.get(k)));
            }
        }

        nomi=new ArrayList<String>();
        valori=new ArrayList<Integer>();

        nomi.add(nome);
        valori.add(val);

        customAdapter.add(p);

        primAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data=new Intent();
                data.setClass(getApplicationContext(),MainActivity.class);
                data.putExtra("NOMI",nomi);
                data.putExtra("VALORI",valori);
                startActivity(data);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                customAdapter.remove(p);
            }
        });
    }
}