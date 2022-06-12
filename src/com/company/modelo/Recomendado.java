package com.company.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Recomendado {
    UserData usr;
    Lista lista;
    public Recomendado(UserData usr, Lista lista){
        this.usr = usr;
        this.lista = lista;
    }

    public String recomendarArtista(Lista lista){ //porque escuchaste [artista 1] ... [artista 2]
        String artista = usr.getMasVeces(usr.Artista);
        String ArtRec;
        ArtRec = buscarRelacionado(lista, artista);
        return ArtRec;
    }

    public String buscarRelacionado(Lista lista, String artista){
        Lista l1;
        Lista l2;
        Cancion c1;
        Cancion c2;
        String genSug;
        String artSug;
        l1 = lista.BuscarPor("artista", artista);
        c1 = l1.getCanciones().get((int)(Math.random()*l1.getSize()));
        genSug = c1.getGenero();
        l2 = lista.BuscarPor("genero", genSug);
        c2 = l2.getCanciones().get((int)(Math.random()*l2.getSize()));
        artSug = c2.getArtista();
        while (artSug.equals(artista)){
            c2 = l2.getCanciones().get((int)(Math.random()*l2.getSize()));
            artSug = c2.getArtista();
        }
        return artSug;

    }

    public Lista recomendarSegunHorario(Lista lista){
        LocalDate ld = LocalDate.now();
        LocalDateTime ldt = LocalDateTime.now();
        Lista l1;
        String diaSemana = ld.getDayOfWeek() + "";

        if (ldt.getHour() >= 20 || ldt.getHour() <=5){ // Noche
            if (diaSemana.equals("FRIDAY") || diaSemana.equals("SATURDAY")){ // Noche de rumbaaa
                l1 = lista.BuscarPor("genero", "cachengue");

                return l1;
            }else{
                l1 = lista.BuscarPor("genero", "R&B");
                return  l1;
            }
        } else {
            l1 = lista.BuscarPor("genero", "Pop");
            return l1;
        }
    }

}
