package com.company.modelo;

import com.company.modelo.Cancion;
import com.company.modelo.Lista;

import java.util.ArrayList;

public class Reproductor {

    private int duracion;
    private ArrayList<Cancion> canciones;
    private Cancion cancion;
    private Lista listaSonando;

    public Reproductor(){

    }

    public void selectLista(Lista listaSonando){
        //hay que ver como hacer
        this.listaSonando = listaSonando;
    }

    public void play(Cancion cancion){
        //hay que ver como hacer
        this.cancion = cancion;
    }

    public void siguiente(Cancion cancion){
        //hay que ver como hacer
        listaSonando.getSiguienteCancion(cancion);
    }


}
