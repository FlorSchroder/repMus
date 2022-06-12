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
        this.listaSonando = null;

    }

    public void selectLista(Lista listaSonando){
        //hay que ver como hacer
        this.listaSonando = listaSonando;
    }
    public Lista getLista(){
            if (listaSonando != null){
                return listaSonando;
            }else {
                System.out.println("No se ha asignado ninguna lista de reproduccion a este reproductor");
                return null;
            }
    }

    public void play(Cancion cancion){
        //hay que ver como hacer
        this.cancion = cancion;
    }

    public void siguiente(Cancion cancion){
        //hay que ver como hacer
        listaSonando.getSiguienteCancion(cancion);
    }

    public String buscar (String cancion){
        if (!listaSonando.getLista().isEmpty()){
            return listaSonando.buscar(cancion);
        }else { return  "No existe la cancion " + cancion; }
    }


}
