package com.company.modelo;

import java.util.HashMap;
import java.util.Set;

public class UserData {
    HashMap<String,Integer> Genero;
    HashMap<String,Integer> Artista;
    HashMap<String,Integer> Favoritos;
    HashMap<String,Integer> Escuchados;

    public UserData(){
        Genero = new HashMap<>();
        Artista = new HashMap<>();
        Favoritos = new HashMap<>();
        Escuchados = new HashMap<>();
    }

    public int getVeces(HashMap<String,Integer> tipo, String key) {
        return tipo.get(key);
    }

    public void addVeces(HashMap<String,Integer> mapa, String key) {
        if (mapa.containsKey(key)){
            int valor;
            valor = mapa.get(key);
            valor++;
            mapa.put(key, valor);
        } else {
            mapa.put(key, 1);
        }

    }

    public String getMasVeces(HashMap<String,Integer> mapa, String key){
        Set<String> setClaves = mapa.keySet();
        int contador = 0;
        int aux;
        String mayor = null;
        for (String i : setClaves){
            aux = mapa.get(i);
            if (aux > contador){
                contador = aux;
                mayor = i;
            }
        }
        return mayor;
    }

}
