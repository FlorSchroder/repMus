package com.company;
import com.company.modelo.*;
import com.company.view.MarcoBusqueda;
import com.company.view.MarcoPrincipal;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Reproductor reproductor = Reproductor.getInstance();
        MarcoPrincipal m1 = new MarcoPrincipal(reproductor);
        m1.setVisible(true);
        m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}