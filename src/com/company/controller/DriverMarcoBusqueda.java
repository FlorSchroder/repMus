package com.company.controller;

import com.company.modelo.Lista;
import com.company.modelo.Reproductor;
import com.company.view.MarcoBusqueda;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
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
            Lista lista = marcoBsqueda.getReproductor().getListaSonando().BuscarPor( "nombre",marcoBsqueda.textBusqueda.getText());
           if (lista == null) {
               System.out.println("No existe la cancion");
           }
        }
        /*if (marcoBsqueda.btnTabla == e.getSource()) {
            System.out.println("btn tabla");
        }*/

    }


}

