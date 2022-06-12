package com.company.modelo;

import com.company.modelo.Cancion;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    public int getSize(){
        return canciones.size();
    }

    public ArrayList<Cancion> getLista(){
        return canciones;
    }

    public String buscar (String cancion){
        String c = null;
        if (!canciones.isEmpty()){
            for (int i = 0; i < canciones.size(); i++) {
                if(cancion.equalsIgnoreCase(canciones.get(i).getNombre())){
                    return canciones.get(i).getNombre();
                }else { c = "No existe la cancion: " + cancion; }
            }
        }else {c = "La lista: " + this.nombre + " esta vacia";}
        return c;
    }

    public void printCanciones(){
        if (canciones.size() != 0)
        for (int i = 0; i < canciones.size(); i++) {
            System.out.println(canciones.get(i).getNombre());
        }else{System.out.println("No hay canciones en esta lista de reproduccion");}
    }

    public Lista BuscarPor(String param, String valor){
        Lista listaRes = new Lista("Resultados");
        for (int i = 0; i<this.getSize(); i++){
            if (param.equals("nombre")){
                Cancion c;
                String nom;
                c = this.canciones.get(i);
                nom = c.getNombre();
                if (nom.equalsIgnoreCase(valor)){
                    listaRes.addCanciones(c);
                }

            }else if (param.equals("genero")){
                Cancion c;
                String gen;
                c = this.canciones.get(i);
                gen = c.getGenero();
                if (gen.equalsIgnoreCase(valor)){
                    listaRes.addCanciones(c);
                }

            }else if (param.equals("artista")){
                Cancion c;
                String art;
                c = this.canciones.get(i);
                art = c.getArtista();
                if (art.equalsIgnoreCase(valor)){
                    listaRes.addCanciones(c);
                }
            }
        }

        return listaRes;
    }




}
