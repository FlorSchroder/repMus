package com.company.view;

import com.company.controller.DriverMarcoBusqueda;
import com.company.modelo.Cancion;
import com.company.modelo.Reproductor;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MarcoBusqueda extends JFrame {
    private MarcoPrincipal marcoPrincipal;
    private Reproductor reproductor;
    private String nombre;

    public MarcoBusqueda(MarcoPrincipal marcoPrincipal, String nombre, Reproductor reproductor){
        this.marcoPrincipal = marcoPrincipal;
        this.reproductor = reproductor;
        this.nombre = nombre;

        setBounds(250,200,800,400);
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
        tabla = new JTable(modeloDatos);
        btnTabla = new botonTabla();
        btnTabla.addActionListener(new DriverMarcoBusqueda(this));
        tabla.getColumn("Acciones").setCellRenderer(btnTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // PANEL INFERIOR //
        JPanel panelInf = new JPanel();
        panelInf.setLayout(new GridLayout(2,1));


        JPanel panelProgress = new JPanel();
        panelProgress.setLayout(new FlowLayout());
        JSlider barra = new JSlider();
        nombreCancion = new JLabel("Nombre: ");
        panelProgress.add(nombreCancion);

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
    public JTable tabla;
    public JLabel nombreCancion;
    public botonTabla btnTabla;

    class ModeloDatos extends AbstractTableModel {
        int altura = 0;

        @Override
        public int getRowCount() {
            if (reproductor.listaExiste(nombre)){
                altura = reproductor.buscar(nombre).getSize();
            }
            return altura;
        }

        @Override
        public int getColumnCount() {
            return 4;
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

        @Override
        public void setValueAt (Object aValue, int rowIndex, int columnIndex){
            Cancion cancion = new Cancion();
            if (reproductor.listaExiste(nombre)){
                cancion = reproductor.buscar(nombre).getCanciones().get(rowIndex);
            }

            switch (columnIndex){
                case 0:
                    cancion.getGenero();
                    break;
                case 1:
                    cancion.getArtista();
                    break;
                case 2:
                    cancion.getGenero();
                    break;
            }
        }

        @Override
        public Object getValueAt (int rowIndex, int columnIndex){
            Cancion cancion = new Cancion();
            if (reproductor.listaExiste(nombre)){
                cancion = reproductor.buscar(nombre).getCanciones().get(rowIndex);
            }

            switch (columnIndex){
                case 0:
                    return cancion.getNombre();
                case 1:
                    return cancion.getArtista();
                case 2:
                    return cancion.getGenero();
               // case 3:
                   // return btnTabla;
            }
            return null;
        }
    }

    class botonTabla extends JButton implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value != null) {
                setText("");
            } else {
                setText("Descargar");
            }
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            return this;
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
