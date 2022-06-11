package com.company.controller;

import com.company.view.MarcoPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver implements ActionListener {
    private MarcoPrincipal marco;
    public Driver(MarcoPrincipal marco){
        this.marco = marco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (marco.b1 == e.getSource()){
            System.out.println("boton b1");
        }
        if (marco.b2 == e.getSource()){
            System.out.println("boton b2");
        }
        if (marco.b3 == e.getSource()){
            System.out.println("boton b3");
        }
        if (marco.b4 == e.getSource()){
            System.out.println("boton b4");
        }
        if (marco.b4 == e.getSource()){
            System.out.println("boton b5");
        }
        if (marco.b4 == e.getSource()){
            System.out.println("boton b6");
        }
        if (marco.btnBuscar == e.getSource()){
            System.out.println(marco.textBusqueda.getText());
        }
    }
}
