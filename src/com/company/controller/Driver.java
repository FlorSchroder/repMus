package com.company.controller;
import com.company.modelo.Reproductor;
import com.company.view.MarcoBusqueda;
import com.company.view.MarcoPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver implements ActionListener {
    private MarcoPrincipal marco;
    private Reproductor reproductor;

    public Driver(MarcoPrincipal marco){
        this.marco = marco;
        this.reproductor = marco.getReproductor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (marco.b1 == e.getSource()){
            try {
                MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco, "Nuevo Artista", reproductor, reproductor.getRecomendaciones());
                marcoBsqueda.setVisible(true);
                marco.setVisible(false);
            }catch (Exception ee){
                JOptionPane.showMessageDialog(marco,"No hay canciones en la lista");
            }
        }
        if (marco.b2 == e.getSource()){
            try {
                MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco, "Dia Chill", reproductor, reproductor.getDiaNoche());
                marcoBsqueda.setVisible(true);
                marco.setVisible(false);
            }catch (Exception ee){
                JOptionPane.showMessageDialog(marco,"No hay canciones en la lista");
            }
        }
        if (marco.b3 == e.getSource()){
            try {
                MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco, "Para Salir", reproductor, reproductor.getCancionesRepMus());
                marcoBsqueda.setVisible(true);
                marco.setVisible(false);
            }catch (Exception ee){
                JOptionPane.showMessageDialog(marco,"No hay canciones en la lista");
            }
        }
        if (marco.b4 == e.getSource()){
            try {
                MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco, "Me Gusta", reproductor, reproductor.getMegusta());
                marcoBsqueda.setVisible(true);
                marco.setVisible(false);

            }catch (Exception ee){
                JOptionPane.showMessageDialog(marco,"No hay canciones en la lista");
            }
        }
        if (marco.b5 == e.getSource()){
            System.out.println("ttt");
            reproductor = reproductor.limpiarDatos();
        }
        if (marco.b6 == e.getSource()){
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco, "Canciones RepMus", reproductor, reproductor.getCancionesRepMus());

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


