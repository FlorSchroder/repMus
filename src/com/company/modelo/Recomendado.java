package com.company.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Recomendado {

    public Recomendado(){

    }

    public String recomendarArtista(Reproductor r){ //porque escuchaste [artista 1] ... [artista 2]
        String artista = r.getUsr().getMasVeces(r.getUsr().Artista);
        String ArtRec;
        ArtRec = buscarRelacionado(r.getCancionesRepMus(), artista); //usamos las cancionesRemMus siempre pq puede recomendar cualquier cancion este o no descargada
        r.recomendarArtista(ArtRec);
        return ArtRec;
    }

    public Lista recomendarGenero(Reproductor r){
        String genero = r.getUsr().getMasVeces(r.getUsr().Genero);
        Lista lista = r.getCancionesRepMus().BuscarPor("genero", genero);
        return lista;
    }
    public String recomendarGeneroString(Reproductor r){
        String genero = r.getUsr().getMasVeces(r.getUsr().Genero);
        return genero;
    }

    public String buscarRelacionado(Lista lista, String artista){
        Lista l1;
        Lista l2;
        Cancion c1 = new Cancion();
        Cancion c2 = new Cancion();
        String genSug;
        String artSug;
        l1 = lista.BuscarPor("artista", artista);
        try {
            c1 = l1.getCanciones().get((int)(Math.random()*l1.getSize()));
        }catch (Exception e){
            System.out.println("No hay canciones en la lista");
        }
        genSug = c1.getGenero();
        l2 = lista.BuscarPor("genero", genSug);
        try {
            c2 = l2.getCanciones().get((int)(Math.random()*l2.getSize()));
        }catch (Exception e){
            System.out.println("No hay canciones en la lista");
        }
        artSug = c2.getArtista();
        while (artSug.equals(artista)){
            c2 = l2.getCanciones().get((int)(Math.random()*l2.getSize()));
            artSug = c2.getArtista();
        }
        return artSug;

    }

    public Lista recomendarSegunHorario(Reproductor r){
        LocalDate ld = LocalDate.now();
        LocalDateTime ldt = LocalDateTime.now();
        Lista l1;
        String diaSemana = ld.getDayOfWeek() + "";

        if (ldt.getHour() >= 20 || ldt.getHour() <=5){ // Noche
            if (diaSemana.equals("FRIDAY") || diaSemana.equals("SATURDAY")){ // Noche de rumbaaa
                l1 = r.getCancionesRepMus().BuscarPor("genero", "cachengue");

                return l1;
            }else{
                l1 = r.getCancionesRepMus().BuscarPor("genero", "R&B");
                return  l1;
            }
        } else {
            l1 = r.getCancionesRepMus().BuscarPor("genero", "Pop");
            return l1;
        }
    }

}
