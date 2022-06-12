package com.company;
import com.company.modelo.Cancion;
import com.company.modelo.Lista;
import com.company.modelo.Reproductor;
import com.company.modelo.UserData;
import com.company.view.MarcoBusqueda;
import com.company.view.MarcoPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UserData usr = new UserData();
        MarcoPrincipal m1 = new MarcoPrincipal();
        m1.setVisible(true);
        m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Reproductor reproductor = new Reproductor();

        reproductor.buscar("canciones repmus").printCanciones();
    }
}
