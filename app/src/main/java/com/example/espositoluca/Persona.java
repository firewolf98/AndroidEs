package com.example.espositoluca;

public class Persona {
    String nome;
    int val;

    public Persona(String n,int v) {
        nome=n;
        val=v;
    }

    public String getNome(){return nome;}

    public int getVal(){return val;}
}
