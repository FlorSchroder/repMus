package com.company;

import java.util.ArrayList;

public class Lista {
    private String nombre;
    private ArrayList<Cancion> canciones;

    public Lista(String nombre){
        this.nombre = nombre;
        canciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public void addCanciones(Cancion cancion){
        canciones.add(cancion);
    }

    public void removeCancion(Cancion cancion){
        canciones.remove(cancion);
    }

    public Cancion getSiguienteCancion(Cancion c1){
        Cancion c2;
        if(canciones.contains(c1) && (canciones.get((canciones.indexOf(c1) + 1))!= null))  {
            c2 = canciones.get((canciones.indexOf(c1) + 1));
        }else {c2 = canciones.get(0);}
        return c2;
    }

    public Cancion getAnteriorCancion(Cancion c1){
        Cancion c3;
        if(canciones.contains(c1) && (canciones.get((canciones.indexOf(c1)-1)) != null)) {
            c3 = canciones.get((canciones.indexOf(c1)-1));
        }
        else {c3 = canciones.get(0);}
        return c3;
    }


}
