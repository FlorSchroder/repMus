package com.company.controller;

import com.company.modelo.Lista;
import com.company.modelo.Recomendado;
import com.company.modelo.Reproductor;
import com.company.view.MarcoBusqueda;
import com.company.view.MarcoPrincipal;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DriverMarcoBusqueda implements ActionListener {
    private MarcoBusqueda marcoBsqueda;
    private Reproductor reproductor;
    private Recomendado recomendado;

    //public DriverMarcoBusqueda(MarcoBusqueda marcoBsqueda, Reproductor reproductor){
      //  this.marcoBsqueda = marcoBsqueda;
    //}
    public DriverMarcoBusqueda(MarcoBusqueda marcoBsqueda){
        this.marcoBsqueda = marcoBsqueda;
        recomendado = new Recomendado();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (marcoBsqueda.btnVolver == e.getSource()) {
            marcoBsqueda.getMarcoPrincipal().setVisible(true);
            MarcoPrincipal mp = marcoBsqueda.getMarcoPrincipal();

            marcoBsqueda.setVisible(false);
            System.out.println();
            if (!marcoBsqueda.getReproductor().getUsr().isEmptyArtist()){
                mp.b1.setEnabled(true);
                String ArtRecom = recomendado.recomendarArtista(marcoBsqueda.getReproductor().getListaSonando(), marcoBsqueda.getReproductor().getUsr());
                mp.b1.setText("Probá con " + ArtRecom);
            }
        }
        if (marcoBsqueda.btnBuscar == e.getSource()) {
            Lista lista = marcoBsqueda.getReproductor().getListaSonando().BuscarPor( "nombre",marcoBsqueda.textBusqueda.getText());

           if (lista == null) {
               System.out.println("No existe la cancion");
           }
        }
    }


}

