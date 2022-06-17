package com.company.controller;

import com.company.modelo.Lista;
import com.company.modelo.Recomendado;
import com.company.view.MarcoBusqueda;
import com.company.view.MarcoPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverMarcoBusqueda implements ActionListener {
    private MarcoBusqueda marcoBsqueda;
    private Recomendado recomendado;

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
                String ArtRecom = recomendado.recomendarArtista(marcoBsqueda.getReproductor());
                mp.b1.setText("Probá con " + ArtRecom);
                mp.b1.setEnabled(true);
                mp.b3.setText("Segui escuchando " + recomendado.recomendarGeneroString(marcoBsqueda.getReproductor()));
                mp.b3.setEnabled(true);
            }
        }
        if (marcoBsqueda.btnBuscar == e.getSource()) {
            Lista lista = marcoBsqueda.getLista().BuscarPor( "nombre",marcoBsqueda.textBusqueda.getText());

           if (lista == null) {
               System.out.println("No existe la cancion");
           }
        }
    }
}

