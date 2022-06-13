package com.company.controller;
import com.company.Main;
import com.company.modelo.Lista;
import com.company.modelo.Recomendado;
import com.company.modelo.Reproductor;
import com.company.modelo.UserData;
import com.company.view.MarcoBusqueda;
import com.company.view.MarcoPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver implements ActionListener {
    private MarcoPrincipal marco;


    public Driver(MarcoPrincipal marco){
        this.marco = marco;

    }
    public Reproductor reproductor = new Reproductor();
    public Recomendado recomendado = new Recomendado();


    @Override
    public void actionPerformed(ActionEvent e) {
       /* if (!usr.isEmptyArtist()){
            System.out.println("LLega");
            marco.b1.setText("Probá con " + usr.getMasVeces(usr.getArtista()));
            marco.b1.setEnabled(true);
        }*/

        if (marco.b1 == e.getSource()){
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco, "Nuevo Artista", reproductor);
            marcoBsqueda.setVisible(true);
            marco.setVisible(false);
        }
        if (marco.b2 == e.getSource()){
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco, "Dia Chill", reproductor);
            marcoBsqueda.setVisible(true);
            marco.setVisible(false);
        }
        if (marco.b3 == e.getSource()){
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco, "Para Salir", reproductor);
            marcoBsqueda.setVisible(true);
            marco.setVisible(false);
        }
        if (marco.b4 == e.getSource()){
            try {
                reproductor.selectListaSonando(reproductor.buscar("Me Gusta"));
                System.out.println(reproductor.getListaSonando().getNombre());
                MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco, "Me Gusta", reproductor);
                marcoBsqueda.setVisible(true);
                marco.setVisible(false);

            }catch (Exception ee){
                ee.printStackTrace();
                JOptionPane.showMessageDialog(marco,"No hay canciones en la lista");
            }
        }
        if (marco.b5 == e.getSource()){
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco, "Nueva Lista", reproductor);
            marcoBsqueda.setVisible(true);
            marco.setVisible(false);
        }
        if (marco.b6 == e.getSource()){
            reproductor.selectListaSonando(reproductor.buscar("canciones Repmus"));
            System.out.println(reproductor.getListaSonando().getNombre());
            MarcoBusqueda marcoBsqueda= new MarcoBusqueda(marco, "Canciones RepMus", reproductor);

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


