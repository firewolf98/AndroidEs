package com.example.espositoluca;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button meno,piu,secAct;
    EditText name;
    TextView valore;
    int val;
    String nome;
    ArrayList<String> nomi;
    ArrayList<Integer> valori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent data=getIntent();
        nomi=data.getStringArrayListExtra("NOMI");
        valori=data.getIntegerArrayListExtra("VALORI");

        meno=findViewById(R.id.meno);
        piu=findViewById(R.id.piu);
        secAct=findViewById(R.id.secAct);
        name=findViewById(R.id.name);
        valore=findViewById(R.id.valore);
        val=0;
        nome="";

        meno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val=Integer.parseInt(valore.getText().toString());
                if (val>0) {
                    val--;
                    valore.setText(val+"");
                }
            }
        });

        piu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val=Integer.parseInt(valore.getText().toString());
                val++;
                valore.setText(val+"");
            }
        });

        secAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome=name.getText().toString();
                if(!nome.equals("")){
                    Intent i=new Intent();
                    i.setClass(getApplicationContext(),MainActivity2.class);
                    i.putExtra("NOME",nome);
                    i.putExtra("VALORE",val);
                    i.putExtra("NOMI",nomi);
                    i.putExtra("VALORI",valori);
                    name.setText("");
                    valore.setText("0");
                    startActivity(i);
                }
            }
        });
    }
}