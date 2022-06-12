package com.company.controller;

import com.company.view.MarcoBusqueda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverMarcoBusqueda implements ActionListener {
    private MarcoBusqueda marcoBsqueda;

    public DriverMarcoBusqueda(MarcoBusqueda marcoBsqueda){
        this.marcoBsqueda = marcoBsqueda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (marcoBsqueda.btnVolver == e.getSource()) {
            marcoBsqueda.getMarcoPrincipal().setVisible(true);
            marcoBsqueda.setVisible(false);
        }

    }
}

