package com.company.view;

import com.company.controller.DriverMarcoBusqueda;
import com.company.modelo.Lista;
import com.company.modelo.Reproductor;
import com.company.modelo.Cancion;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarcoBusqueda extends JFrame {
    private MarcoPrincipal marcoPrincipal;
    private Reproductor reproductor;
    private Lista lista;

    public MarcoBusqueda(MarcoPrincipal marcoPrincipal, String nombre, Reproductor reproductor, Lista lista){
        this.marcoPrincipal = marcoPrincipal;
        this.reproductor = reproductor;
        this.lista = lista;

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
        dm.setDataVector(reproductor.getData(reproductor, lista), new Object[]{"Nombre", "Artista", "Genero", "Descargar", "Reproducir"});
        tabla = new JTable(dm);

        //modeloDatos.addTableModelListener(new DriverTabla());
        //btnTabla = new botonTabla();

        //btnTabla.addActionListener(new DriverMarcoBusqueda(this));
        //tabla.setDefaultRenderer(Object.class, new TablaRender());
        tabla.getColumn("Descargar").setCellRenderer(new ButtonRenderer());
        tabla.getColumn("Descargar").setCellEditor(new ButtonEditor(new JCheckBox()));
        tabla.getColumn("Reproducir").setCellRenderer(new ButtonRendererRep());
        tabla.getColumn("Reproducir").setCellEditor(new ButtonEditorRep(new JCheckBox()));




        //tabla.getColumn("Acciones").setCellRenderer(btnTabla2);
        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // PANEL INFERIOR //
        JPanel panelInf = new JPanel();
        panelInf.setLayout(new GridLayout(2,1));


        JPanel panelProgress = new JPanel();
        panelProgress.setLayout(new FlowLayout());
        barra = new JProgressBar();
        if(reproductor.isOnPlay(lista)) {
            for (int i = 0; i < reproductor.songOnPlay(lista).getDuracion(); i++) {
                barra.setValue(reproductor.getProgreso(lista) + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
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
    //public JButton button;
    public JButton btnVolver;
    public JLabel labelBusqueda;
    public JTextField textBusqueda;
    public JTable tabla;
    public JLabel nombreCancion;
    public JProgressBar barra;


    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }



        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            ImageIcon downloaded = new ImageIcon("src/main/java/com/company/images/downloaded.png");
            ImageIcon download = new ImageIcon("src/main/java/com/company/images/download.png");
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }

            if (lista != null){
                if (lista.getCanciones().get(row).isDescargado()){
                    setIcon(downloaded);
                } else {
                    setIcon(download);
                }
            }

            return this;
        }
    }

    class ButtonRendererRep extends JButton implements TableCellRenderer {

        public ButtonRendererRep() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            ImageIcon play = new ImageIcon("src/main/java/com/company/images/play.png");
            ImageIcon pause = new ImageIcon("src/main/java/com/company/images/pause.png");

            if (value == null){
                setIcon(play);
            }else {
                setIcon(pause);
            }
            return this;
        }
    }


    class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.setSize(20,20);
            ImageIcon downloaded = new ImageIcon("src/main/java/com/company/images/downloaded.png");
            ImageIcon download = new ImageIcon("src/main/java/com/company/images/download.png");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(tabla.getSelectedRow());
                    if (lista.getCanciones().get(tabla.getSelectedRow()).isDescargado()){

                        //JOptionPane.showMessageDialog(button, "Eliminado!");
                        lista.getCanciones().get(tabla.getSelectedRow()).setDescargado(false);
                        //reproductor.eliminarCancion(reproductor.getListaSonando().getCanciones().get(tabla.getSelectedRow()));// ACAAA

                    }else {
                        lista.getCanciones().get(tabla.getSelectedRow()).setDescargado(true);
                        //reproductor.descargarCancion(reproductor.getListaSonando().getCanciones().get(tabla.getSelectedRow()));
                        //JOptionPane.showMessageDialog(button, "Descargado!");

                    }

                }
            });

            lista.getCanciones().get(this.getComponent().getX()).isDescargado();

            if (lista.getCanciones().get(this.getComponent().getX()).isDescargado()){

                button.setIcon(download);
            }else {

                button.setIcon(downloaded);
            }
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }

            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {

            }
            isPushed = false;
            return null;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }

    class ButtonEditorRep extends DefaultCellEditor {

        protected JButton button;
        private boolean isPushed;

        public ButtonEditorRep(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.setSize(20,20);
            ImageIcon play = new ImageIcon("src/main/java/com/company/images/play.png");
            ImageIcon pause = new ImageIcon("src/main/java/com/company/images/pause.png");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (lista.getCanciones().get(tabla.getSelectedRow()).isPlaying()){

                        lista.getCanciones().get(tabla.getSelectedRow()).setPlaying(false);

                    }else {
                        if (reproductor.isOnPlay(lista)){
                            Cancion enRep;
                            enRep = reproductor.songOnPlay(lista);
                            reproductor.stop(enRep);
                            lista.getCanciones().get(tabla.getSelectedRow()).setPlaying(true);
                            reproductor.play(lista.getCanciones().get(tabla.getSelectedRow()));

                        }else{
                            reproductor.play(lista.getCanciones().get(tabla.getSelectedRow()));
                            lista.getCanciones().get(tabla.getSelectedRow()).setPlaying(true);
                        }

                    }

                }
            });

            if (lista.getCanciones().get(this.getComponent().getX()).isPlaying()){

                button.setIcon(play);
            }else {
                button.setIcon(pause);
            }



        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }

            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {

            }
            isPushed = false;
            return null;
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

    public Lista getLista(){
        return lista;
    }
}
