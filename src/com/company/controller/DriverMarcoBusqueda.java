package com.company.controller;

import com.company.modelo.Reproductor;
import com.company.view.MarcoBusqueda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverMarcoBusqueda implements ActionListener {
    private MarcoBusqueda marcoBsqueda;
    //private Reproductor reproductor;

    //public DriverMarcoBusqueda(MarcoBusqueda marcoBsqueda, Reproductor reproductor){
      //  this.marcoBsqueda = marcoBsqueda;
    //}
    public DriverMarcoBusqueda(MarcoBusqueda marcoBsqueda){
        this.marcoBsqueda = marcoBsqueda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (marcoBsqueda.btnVolver == e.getSource()) {
            marcoBsqueda.getMarcoPrincipal().setVisible(true);
            marcoBsqueda.setVisible(false);
        }
        if (marcoBsqueda.btnBuscar == e.getSource()) {
            try {
                System.out.println(marcoBsqueda.getReproductor().buscar(marcoBsqueda.textBusqueda.getText()));
            }catch (Exception t){
                System.out.println("No hay canciones en la lista");
            }
        }

    }
}

