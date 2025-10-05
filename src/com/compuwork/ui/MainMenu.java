package com.compuwork.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        setTitle("CompuWork - Menú Principal");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel titulo = new JLabel("Menú Principal", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btnEmpleado = new JButton("Gestión de Empleados");
        JButton btnDepartamento = new JButton("Gestión de Departamentos");
        JButton btnReporte = new JButton("Gestión de Reportes");

        panel.add(titulo);
        panel.add(btnEmpleado);
        panel.add(btnDepartamento);
        panel.add(btnReporte);

        add(panel);

        // Acciones de botones
        btnEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmpleadoUI();
            }
        });

        btnDepartamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DepartamentoUI();
            }
        });

        btnReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReporteUI();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
