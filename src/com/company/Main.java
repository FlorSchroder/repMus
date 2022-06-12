package com.company;
import com.company.modelo.*;
import com.company.view.MarcoBusqueda;
import com.company.view.MarcoPrincipal;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        UserData usr = new UserData();
        MarcoPrincipal m1 = new MarcoPrincipal();
        m1.setVisible(true);
        m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        usr.addVeces("artista", "Arctic Monkeys");


        Reproductor reproductor = new Reproductor();
        Lista l;
        Lista l2;
        l = reproductor.buscar("canciones repmus");
        Recomendado recomendado = new Recomendado(usr,l);
        System.out.println(recomendado.recomendarArtista(l));
        //l2.printCanciones();

    }
}
