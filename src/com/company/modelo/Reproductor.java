package com.company.modelo;

import com.company.modelo.Cancion;
import com.company.modelo.Lista;

import java.util.ArrayList;

public class Reproductor {

    private int duracion;
    private Cancion cancion;
    private Lista listaSonando;
    private ArrayList<Lista> listas;
    private Lista cancionesRepMus;

    public Reproductor(){
        this.listaSonando = null;
        cancionesRepMus = new Lista("Canciones RepMus" );
        ndea();
        listas = new ArrayList<>();
        listas.add(cancionesRepMus);
    }

    public void addLista(Lista listaNueva){
        listas.add(listaNueva);
    }

    public void selectListaSonando(Lista listaSonando){
        //hay que ver como hacer
        this.listaSonando = listaSonando;
    }
    public Lista getListaSonando(){
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

    public Lista buscar (String nombre){
        if (!listas.isEmpty()){
            for (int i = 0; i < listas.size(); i++) {
                if (nombre.equalsIgnoreCase(listas.get(i).getNombre())){
                    System.out.println("Se ha encontrado la lista!");
                    return listas.get(i);
                }else {
                    System.out.println("No esxiste una lista con ese nombre en el reproductor");
                    return null;
                }
            }
        }else {
            System.out.println("No hay listas en este reproductor");
            return null;
        }
        return null;
    }

    public boolean listaExiste(String nombre){
        if (buscar(nombre) != null){
            return true;
        }else{ return false; }
    }

    private void ndea(){
        Cancion c0 = new Cancion("Puesto", "Indie", "Babasonicos", 205);
        Cancion c1 = new Cancion("Jugo", "Indie", "Los Espiritus", 240);
        Cancion c2 = new Cancion("Agua Marfil", "Indie", "Usted Señalemelo", 252);
        Cancion c3 = new Cancion("Big Bang", "Indie", "Usted Señalemelo", 294);
        Cancion c4 = new Cancion("Style", "Pop", "Taylor Swift", 231);
        Cancion c5 = new Cancion("Golden", "Pop", "Harry Styles", 209);
        Cancion c6 = new Cancion("Deja Vu", "Pop", "Olivia Rodrigo", 217);
        Cancion c7 = new Cancion("Plastic Hearts", "Pop", "Miley Cyrus", 208);
        Cancion c8 = new Cancion("The Adults Are Talking ", "Rock Alternativo", "The Strokes", 224);
        Cancion c9 = new Cancion("Do I Wanna Know", "Rock Alternativo", "Arctic Monkeys", 198);
        Cancion c10 = new Cancion("Mr Brightside", "Rock Alternativo", "The Killers", 270);
        Cancion c11 = new Cancion("Chocolate", "Rock Alternativo", "The 1975", 187);
        Cancion c12 = new Cancion("La triple T", "Cachengue", "Tini", 160);
        Cancion c13 = new Cancion("Cuatro Veinte", "Cachengue", "Emilia", 192);
        Cancion c14 = new Cancion("Salimo de Noche", "Cachengue", "Tiago PZK", 167);
        Cancion c15 = new Cancion("Plan A", "Cachengue", "Paulo Londra", 187);
        cancionesRepMus.addCanciones(c0);
        cancionesRepMus.addCanciones(c1);
        cancionesRepMus.addCanciones(c2);
        cancionesRepMus.addCanciones(c3);
        cancionesRepMus.addCanciones(c4);
        cancionesRepMus.addCanciones(c5);
        cancionesRepMus.addCanciones(c6);
        cancionesRepMus.addCanciones(c7);
        cancionesRepMus.addCanciones(c8);
        cancionesRepMus.addCanciones(c9);
        cancionesRepMus.addCanciones(c10);
        cancionesRepMus.addCanciones(c11);
        cancionesRepMus.addCanciones(c12);
        cancionesRepMus.addCanciones(c13);
        cancionesRepMus.addCanciones(c14);
        cancionesRepMus.addCanciones(c15);
    }
}