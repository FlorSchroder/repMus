package com.company;

public class Cancion {

    private String nombre;
    private String genero;
    private String artista;
    private int duracion;

    public Cancion(){}

    public Cancion(String nombre, String genero, String artista, int duracion){
        this.nombre = nombre;
        this.genero = genero;
        this.artista = artista;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
