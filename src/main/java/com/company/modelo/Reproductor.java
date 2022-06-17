package com.company.modelo;

import java.util.ArrayList;

public class Reproductor {

    private static Reproductor uniqueInstance;
    private static ArrayList<Lista> listas;
    private static Lista cancionesRepMus;
    private static Lista meGusta;
    private static Lista artista;
    private static Lista genero;
    private static Lista diaNoche;
    public Object Data[][];
    private static UserData usr;
    private static Recomendado recomendado;

    private Reproductor(){}

    public static Reproductor getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Reproductor();
            cancionesRepMus = new Lista("Canciones RepMus" );
            meGusta = new Lista("Me Gusta");
            artista = new Lista("Nuevo Artista");
            diaNoche = new Lista("diaNoche");
            diaNoche = new Lista("Nuevo Genero");
            ndea();
            listas = new ArrayList<>();
            listas.add(cancionesRepMus);
            listas.add(meGusta);
            listas.add(artista);
            listas.add(diaNoche);
            listas.add(genero);
            usr = new UserData();
        }
        return uniqueInstance;
    }

    public void play(Cancion cancion){ //
        cancion.setPlaying(true);
        usr.addVeces("genero", cancion.getGenero());
        usr.addVeces("artista", cancion.getArtista());
        usr.addVeces("favoritos", cancion.getNombre());
        usr.addVeces("escuchados", cancion.getNombre());
    }

    public void stop(Cancion cancion){
        cancion.setPlaying(false);
    }

    /*
    public void siguiente(Cancion cancion){
        play(listaSonando.getSiguienteCancion(cancion));
    }

     */

    public Lista buscar (String nombre){
        if (!listas.isEmpty()){
            for (int i = 0; i < listas.size(); i++) {
                if (nombre.equalsIgnoreCase(listas.get(i).getNombre())){
                    System.out.println("Se ha encontrado la lista!");
                    listas.get(i).printCanciones();
                    return listas.get(i);
                }else {
                    System.out.println("No esxiste una lista con ese nombre en el reproductor");
                }
            }
        }
        return null;
    }

    public Reproductor limpiarDatos(){
        meGusta.getCanciones().clear();
        artista.getCanciones().clear();
        diaNoche.getCanciones().clear();
        genero.getCanciones().clear();
        return this;
    }

    public Object[][] getData(Lista listaSonando){
        Lista lista = this.buscar(listaSonando.getNombre());
        this.Data = new Object[lista.getSize()][4];
        for (int i = 0; i < lista.getSize(); i++){
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

    public Lista getMegusta(){
        return meGusta;
    }
    public Lista getCancionesRepMus(){
        return cancionesRepMus;
    }
    public Lista getRecomendaciones(){
        return artista;
    }
    public Lista getDiaNoche(){
        return diaNoche;
    }
    public Lista getGenero(){
        return genero;
    }

    public boolean isOnPlay(Lista listaSonando){
        for (int i=0; i < listaSonando.getCanciones().size(); i++){
            if(listaSonando.getCanciones().get(i).isPlaying()){
                return true;
            }
        }
        return false;
    }

    public Cancion songOnPlay(Lista listaSonando){
        if (this.isOnPlay(listaSonando)){
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

    public int getProgreso(Lista lista){
        int duracion;
        int progreso;
        duracion = this.songOnPlay(lista).getDuracion();
        progreso = (int) (duracion/100);
        return progreso;

    }

    public UserData getUsr(){
        return usr;
    }

    public void recomendarArtista(String artistaRecoemndado){
        artista.setCanciones(cancionesRepMus.BuscarPor("artista", artistaRecoemndado).getCanciones());
    }

    public void setDiaNoche(Lista lista){
        diaNoche.setCanciones(lista.getCanciones());
    }

    public void setGenero(Lista lista){
        genero.setCanciones(lista.getCanciones());
    }

    public void clearMeGusta(){
        meGusta.getCanciones().clear();
    }
    public void setMeGusta(){
        for (int i = 0; i < cancionesRepMus.getSize(); i++) {
            if(cancionesRepMus.getCanciones().get(i).isDescargado()){
                meGusta.addCanciones(cancionesRepMus.getCanciones().get(i));
            }
        }
    }

    private static void ndea(){
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
        Cancion c17 = new Cancion("Run Cun", "Indie", "Babasonicos", 205);
        Cancion c18 = new Cancion("Puesto", "Indie", "Babasonicos", 205);
        Cancion c19 = new Cancion("Muñeco", "Indie", "Babasonicos", 205);
        Cancion c20 = new Cancion("El Colmo", "Indie", "Babasonicos", 205);
        Cancion c21 = new Cancion("Perdida En El Fuego", "Indie", "Los Espiritus", 240);
        Cancion c22 = new Cancion("La Crecida", "Indie", "Los Espiritus", 240);
        Cancion c23 = new Cancion("Noches De Verano", "Indie", "Los Espiritus", 240);
        Cancion c24 = new Cancion("La Crecida", "Indie", "Los Espiritus", 240);
        Cancion c25 = new Cancion("Don't Blame Me", "Pop", "Taylor Swift", 231);
        Cancion c26 = new Cancion("Lover", "Pop", "Taylor Swift", 231);
        Cancion c27 = new Cancion("Red", "Pop", "Taylor Swift", 231);
        Cancion c28 = new Cancion("I Knew You Were Trouble", "Pop", "Taylor Swift", 231);
        Cancion c29 = new Cancion("Watermelon Sugar", "Pop", "Harry Styles", 209);
        Cancion c30 = new Cancion("Late Night Talking", "Pop", "Harry Styles", 209);
        Cancion c31 = new Cancion("Adore You", "Pop", "Harry Styles", 209);
        Cancion c32 = new Cancion("Sign of the Times", "Pop", "Harry Styles", 209);
        Cancion c33 = new Cancion("Drivers License", "Pop", "Olivia Rodrigo", 217);
        Cancion c34 = new Cancion("Traitor", "Pop", "Olivia Rodrigo", 217);
        Cancion c35 = new Cancion("Never Be Me", "Pop", "Miley Cyrus", 208);
        Cancion c36 = new Cancion("Breaking Ball", "Pop", "Miley Cyrus", 208);

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
        cancionesRepMus.addCanciones(c17);
        cancionesRepMus.addCanciones(c18);
        cancionesRepMus.addCanciones(c19);
        cancionesRepMus.addCanciones(c20);
        cancionesRepMus.addCanciones(c21);
        cancionesRepMus.addCanciones(c22);
        cancionesRepMus.addCanciones(c23);
        cancionesRepMus.addCanciones(c24);
        cancionesRepMus.addCanciones(c25);
        cancionesRepMus.addCanciones(c26);
        cancionesRepMus.addCanciones(c27);
        cancionesRepMus.addCanciones(c28);
        cancionesRepMus.addCanciones(c29);
        cancionesRepMus.addCanciones(c30);
        cancionesRepMus.addCanciones(c31);
        cancionesRepMus.addCanciones(c32);
        cancionesRepMus.addCanciones(c33);
        cancionesRepMus.addCanciones(c34);
        cancionesRepMus.addCanciones(c35);
        cancionesRepMus.addCanciones(c36);
    }
}
