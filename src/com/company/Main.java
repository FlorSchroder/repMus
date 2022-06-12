package com.company;
import com.company.modelo.Cancion;
import com.company.modelo.Lista;
import com.company.modelo.Reproductor;
import com.company.modelo.UserData;
import com.company.view.MarcoBusqueda;
import com.company.view.MarcoPrincipal;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MarcoPrincipal m1 = new MarcoPrincipal();
        m1.setVisible(true);
        m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
