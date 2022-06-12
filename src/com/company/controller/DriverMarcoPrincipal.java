package com.company.controller;

import com.company.modelo.Reproductor;
import com.company.view.MarcoBusqueda;
import com.company.view.MarcoPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverMarcoPrincipal implements ActionListener {
    private MarcoPrincipal marco;

    public DriverMarcoPrincipal(MarcoPrincipal marco){
        this.marco = marco;
    }
    public Reproductor reproductor = new Reproductor();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (marco.b1 == e.getSource()){
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco);
            marcoBsqueda.setVisible(true);
            marco.setVisible(false);
        }
        if (marco.b2 == e.getSource()){
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco);
            marcoBsqueda.setVisible(true);
            marco.setVisible(false);
        }
        if (marco.b3 == e.getSource()){
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco);
            marcoBsqueda.setVisible(true);
            marco.setVisible(false);
        }
        if (marco.b4 == e.getSource()){
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco);
            marcoBsqueda.setVisible(true);
            marco.setVisible(false);
        }
        if (marco.b5 == e.getSource()){
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco);
            marcoBsqueda.setVisible(true);
            marco.setVisible(false);
        }
        if (marco.b6 == e.getSource()){
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco);
            marcoBsqueda.setVisible(true);
            marco.setVisible(false);
        }
        if (marco.btnBuscar == e.getSource()){
            try {
                System.out.println(reproductor.buscar(marco.textBusqueda.getText()));
            }catch (Exception t){
                System.out.println("No hay canciones en la lista");
            }
        }
    }
}


