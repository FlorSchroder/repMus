package com.company.modelo;

public class Recomendado {
    UserData usr;
    public Recomendado(UserData usr){
        this.usr = usr;
    }

    public String RecomendarArtista(){ //porque escuchaste [artista 1] ... [artista 2]
        String artista = usr.getMasVeces(usr.Artista);
        return "artista";
    }


}
