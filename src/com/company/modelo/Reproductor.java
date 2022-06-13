package com.company.modelo;

import com.company.Main;
import com.company.modelo.Cancion;
import com.company.modelo.Lista;

import java.util.ArrayList;

public class Reproductor {

    private int duracion;
    private Cancion cancion;
    private Lista listaSonando;
    private ArrayList<Lista> listas;
    private Lista cancionesRepMus;
    public Object Data[][];
    private boolean isOnPlay;
    private UserData usr = new UserData();

    public Reproductor(){
        this.listaSonando = null;
        cancionesRepMus = new Lista("Canciones RepMus" );
        ndea();
        listas = new ArrayList<>();
        listas.add(cancionesRepMus);
        usr = new UserData();
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

    public void play(Cancion cancion, UserData usr){
        this.cancion = cancion;
        cancion.setPlaying(true);
        usr.addVeces("genero", cancion.getGenero());
        usr.addVeces("artista", cancion.getArtista());
        usr.addVeces("favoritos", cancion.getNombre());
        usr.addVeces("escuchados", cancion.getNombre());
    }

    public void stop(Cancion cancion){
        this.cancion = cancion;
        cancion.setPlaying(false);
    }

    public void siguiente(Cancion cancion, UserData usr){
        play(listaSonando.getSiguienteCancion(cancion), usr);
    }

    public Lista buscar (String nombre){
        if (!listas.isEmpty()){
            for (int i = 0; i < listas.size(); i++) {
                if (nombre.equalsIgnoreCase(listas.get(i).getNombre())){
                 //   System.out.println("Se ha encontrado la lista!");
                    return listas.get(i);
                }else {
                   // System.out.println("No esxiste una lista con ese nombre en el reproductor");
                    return null;
                }
            }
        }else {
           // System.out.println("No hay listas en este reproductor");
        }
        return null;
    }

    public boolean listaExiste(String nombre){
        if (buscar(nombre) != null){
            return true;
        }else{ return false; }
    }

    public Object[][] getData(Lista lista){
        this.selectListaSonando(this.buscar("canciones Repmus"));
        lista = this.buscar("canciones Repmus");
        this.Data = new Object[lista.getSize()][4];
        for (int i=0; i < lista.getSize(); i++){
            for (int j=0; j < 4; j++){
                if (j==0){
                    this.Data[i][j] = lista.getCanciones().get(i).getNombre();
                }else if (j==1){
                    this.Data[i][j] = lista.getCanciones().get(i).getArtista();
                }else if (j==2){
                    this.Data[i][j] = lista.getCanciones().get(i).getGenero();
                }
                else if (j==3){
                    this.Data[i][j] = lista.getCanciones().get(i).isDescargado();
                }

            }
        }
        return Data;
    }


    public boolean isOnPlay(){
        for (int i=0; i < listaSonando.getCanciones().size(); i++){
            if(listaSonando.getCanciones().get(i).isPlaying()){
                return true;
            }
        }
        return false;
    }

    public Cancion songOnPlay(){
        if (this.isOnPlay()){
            for (int i=0; i < listaSonando.getCanciones().size(); i++){
                if(listaSonando.getCanciones().get(i).isPlaying()){
                    return listaSonando.getCanciones().get(i);
                }
            }
        }else {
            return null;
        }
        return null;
    }

    public int getProgreso(){
        int duracion;
        int progreso;
        duracion = this.songOnPlay().getDuracion();
        progreso = (int) (duracion/100);
        return progreso;

    }

    public UserData getUsr(){
        return usr;
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
        Cancion c16 = new Cancion("Cancion Lenta", "R&B", "Paco Oloroso", 187);
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
        cancionesRepMus.addCanciones(c16);
    }
}
