package com.company.view;

import com.company.controller.DriverMarcoBusqueda;
import com.company.modelo.Reproductor;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        //ModeloDatos modeloDatos = new ModeloDatos();
        //tabla = new JTable(modeloDatos);
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][]{{"Hola", "TINI", "Cachengue"},
                {"Chau", "Fulanito", "Rock"}}, new Object[]{"Nombre", "Artista", "Genero", "Acciones"});
        tabla = new JTable(dm);

        //modeloDatos.addTableModelListener(new DriverTabla());
        //btnTabla = new botonTabla();

        //btnTabla.addActionListener(new DriverMarcoBusqueda(this));
        //tabla.setDefaultRenderer(Object.class, new TablaRender());
        tabla.getColumn("Acciones").setCellRenderer(new ButtonRenderer());
        tabla.getColumn("Acciones").setCellEditor(new ButtonEditor(new JCheckBox()));


        //tabla.getColumn("Acciones").setCellRenderer(btnTabla2);
        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());

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
    //public botonTabla btnTabla;
    //public botonTablaRep btnTabla2;

    /*class ModeloDatos extends AbstractTableModel {
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
    }*/

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            setText((value == null) ? "Descargar" : value.toString());
            return this;
        }
    }


    class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                JOptionPane.showMessageDialog(button, label + "Descargado!");
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
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
