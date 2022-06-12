package com.company.view;

import com.company.controller.DriverMarcoBusqueda;
import com.company.modelo.Reproductor;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class MarcoBusqueda extends JFrame {
    private MarcoPrincipal marcoPrincipal;
    private Reproductor reproductor;
    private String nombre;

    public MarcoBusqueda(MarcoPrincipal marcoPrincipal, String nombre, Reproductor reproductor){
        this.marcoPrincipal = marcoPrincipal;
        this.reproductor = reproductor;
        this.nombre = nombre;

        setBounds(500,300,800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new FlowLayout());
        labelBusqueda = new JLabel("Resultados para: " + nombre);
        panelBusqueda.add(labelBusqueda);
        textBusqueda = new JTextField();
        textBusqueda.setColumns(25);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new DriverMarcoBusqueda(this));
        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new DriverMarcoBusqueda(this));

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

    public JButton btnBuscar;

    public JButton btnVolver;
    public JLabel labelBusqueda;
    public JTextField textBusqueda;

    class ModeloDatos extends AbstractTableModel {

        @Override
        public int getRowCount() {
            int altura = 0;
            if (reproductor.listaExiste(nombre)){
                altura = reproductor.buscar(nombre).getSize();
            }
            return altura;
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

    public MarcoPrincipal getMarcoPrincipal() {
        return marcoPrincipal;
    }

    public void setMarcoPrincipal(MarcoPrincipal marcoPrincipal) {
        this.marcoPrincipal = marcoPrincipal;
    }

    public Reproductor getReproductor() {
        return reproductor;
    }

    public void setReproductor(Reproductor reproductor) {
        this.reproductor = reproductor;
    }
}
