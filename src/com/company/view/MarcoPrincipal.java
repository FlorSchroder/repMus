package com.company.view;

import com.company.controller.Driver;

import javax.swing.*;
import java.awt.*;

public class MarcoPrincipal extends JFrame {
    public MarcoPrincipal(){
        setTitle("RepMus");
        setLayout(new BorderLayout());
        setBounds(500,300,800,400);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,3));

        // PANEL SUPERIOR //
        JPanel panelSup = new JPanel();
        panelSup.setLayout(new FlowLayout());
        textBusqueda = new JTextField();
        textBusqueda.setColumns(50);
        textBusqueda.addActionListener(new Driver(this));
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new Driver(this));
        panelSup.add(textBusqueda);
        panelSup.add(btnBuscar);
        add(panelSup, BorderLayout.NORTH);


        // PANEL CENTRAL //
        b1 = new JButton("Probá con [Artista]");
        b2 = new JButton("[Día]");
        b3 = new JButton("[Noche]");
        b4 = new JButton("Me gusta");
        b5 = new JButton("Descargas");
        b6 = new JButton("Mi lista");

        b1.addActionListener(new Driver(this));
        b2.addActionListener(new Driver(this));
        b3.addActionListener(new Driver(this));
        b4.addActionListener(new Driver(this));
        b5.addActionListener(new Driver(this));
        b6.addActionListener(new Driver(this));

        panel1.add(b1);
        panel1.add(b2);
        panel1.add(b3);
        panel1.add(b4);
        panel1.add(b5);
        panel1.add(b6);
        add(panel1, BorderLayout.CENTER);
        // FIN PANEL CENTRAL //

        // PANEL INFERIOR //
        JPanel panelInf = new JPanel();
        panelInf.setLayout(new GridLayout(2,1));

        JPanel panelProgress = new JPanel();
        panelProgress.setLayout(new FlowLayout());
        panelProgress.add(new JProgressBar());
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
    public JButton b1;
    public JButton b2;
    public JButton b3;
    public JButton b4;
    public JButton b5;
    public JButton b6;

    public JTextField textBusqueda;
    public JButton btnBuscar;
}

