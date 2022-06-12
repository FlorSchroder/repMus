package com.company.view;

import com.company.controller.Driver;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class MarcoBusqueda extends JFrame {
    public MarcoBusqueda(){
        setBounds(500,300,800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new FlowLayout());
        JLabel labelBusqueda = new JLabel("Resultados para: [Busqueda]");
        panelBusqueda.add(labelBusqueda);
        JTextField textBusqueda = new JTextField();
        textBusqueda.setColumns(25);
        JButton btnBuscar = new JButton("Buscar");
        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new Driver(this));
        panelBusqueda.add(textBusqueda);
        panelBusqueda.add(btnBuscar);
        panelBusqueda.add(btnVolver);
        add(panelBusqueda, BorderLayout.NORTH);


        //JTable tabla = new JTable(datosFila, datosColumna);
        ModeloDatos modeloDatos = new ModeloDatos();
        JTable tabla = new JTable(modeloDatos);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // PANEL INFERIOR //
        JPanel panelInf = new JPanel();
        panelInf.setLayout(new GridLayout(2,1));

        JPanel panelProgress = new JPanel();
        panelProgress.setLayout(new FlowLayout());
        JSlider barra = new JSlider();

        panelProgress.add(barra);
        panelInf.add(panelProgress);

        JPanel panelBtnRep = new JPanel();
        panelBtnRep.setLayout(new FlowLayout());
        JButton backRep = new JButton("<<");
        JButton Rep = new JButton("|>");
        JButton fordwRep = new JButton(">>");
        panelBtnRep.add(backRep);
        panelBtnRep.add(Rep);
        panelBtnRep.add(fordwRep);
        panelInf.add(panelBtnRep);

        add(panelInf, BorderLayout.SOUTH);

        // FIN PANEL INFERIOR //

    }
    public JButton btnVolver;

    class ModeloDatos extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return 8;
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }
        public String getColumnName(int n){
            switch (n){
                case 0:
                    return "Nombre";
                case 1:
                    return "Artista";
                case 2:
                    return "Género";
                case 3:
                    return "Acciones";
                default:
                    return "Null";
            }
        }
    }


}
