package com.company.modelo;

import java.util.HashMap;
import java.util.Set;

public class UserData {
    HashMap<String,Integer> Genero;
    HashMap<String,Integer> Artista;
    HashMap<String,Integer> Favoritos;
    HashMap<String,Integer> Escuchados;

    public HashMap<String, Integer> getGenero() {
        return Genero;
    }

    public void setGenero(HashMap<String, Integer> genero) {
        Genero = genero;
    }

    public HashMap<String, Integer> getArtista() {
        return Artista;
    }

    public void setArtista(HashMap<String, Integer> artista) {
        Artista = artista;
    }

    public HashMap<String, Integer> getFavoritos() {
        return Favoritos;
    }

    public void setFavoritos(HashMap<String, Integer> favoritos) {
        Favoritos = favoritos;
    }

    public HashMap<String, Integer> getEscuchados() {
        return Escuchados;
    }

    public void setEscuchados(HashMap<String, Integer> escuchados) {
        Escuchados = escuchados;
    }



    public UserData(){
        Genero = new HashMap<>();
        Artista = new HashMap<>();
        Favoritos = new HashMap<>();
        Escuchados = new HashMap<>();
    }

    public int getVeces(String tipo, String key) {
        switch (tipo){
            case "genero":
                return Genero.get(key);
            case "artista":
                return Artista.get(key);
            case "favortios":
                return Favoritos.get(key);
            case "escuchados":
                return Escuchados.get(key);
            default:
                return 0;
        }
    }

    public void addVeces(String mapa, String key) {
        switch (mapa){
            case "genero":
                if (this.Genero.containsKey(key)){
                    int valor;
                    valor = this.Genero.get(key);
                    valor++;
                    this.Genero.put(key, valor);
                } else {
                    this.Genero.put(key, 1);
                }
                break;
            case "artista":
                if (this.Artista.containsKey(key)){
                    int valor;
                    valor = this.Artista.get(key);
                    valor++;
                    this.Artista.put(key, valor);
                } else {
                    this.Artista.put(key, 1);
                }
                break;
            case "favoritos":
                if (this.Favoritos.containsKey(key)){
                    int valor;
                    valor = this.Favoritos.get(key);
                    valor++;
                    this.Favoritos.put(key, valor);
                } else {
                    this.Favoritos.put(key, 1);
                }
                break;
            case "escuchados":
                if (this.Escuchados.containsKey(key)){
                    int valor;
                    valor = this.Escuchados.get(key);
                    valor++;
                    this.Escuchados.put(key, valor);
                } else {
                    this.Escuchados.put(key, 1);
                }
                break;
        }
    }

    public String getMasVeces(HashMap<String,Integer> mapa){
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

    public boolean isEmptyArtist(){
        if(this.Artista.isEmpty()){
            return true;
        }
        return false;
    }

}
