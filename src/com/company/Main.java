package com.company;
import com.company.view.MarcoBusqueda;
import com.company.view.MarcoPrincipal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //MarcoPrincipal m1 = new MarcoPrincipal();
        MarcoBusqueda m1 = new MarcoBusqueda();
        m1.setVisible(true);
        m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
