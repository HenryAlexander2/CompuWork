package com.compuwork;

import com.compuwork.ui.DepartamentoUI;
import com.compuwork.ui.EmpleadoUI;
import com.compuwork.ui.ReporteUI;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame menu = new JFrame("Menú Principal - CompuWork");
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setSize(400, 300);
            menu.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

            JButton btnEmpleados = new JButton("Gestión de Empleados");
            JButton btnDepartamentos = new JButton("Gestión de Departamentos");
            JButton btnReportes = new JButton("Gestión de Reportes");
            JButton btnSalir = new JButton("Salir");

            panel.add(btnEmpleados);
            panel.add(btnDepartamentos);
            panel.add(btnReportes);
            panel.add(btnSalir);

            menu.add(panel);
            menu.setVisible(true);

            btnEmpleados.addActionListener(e -> new EmpleadoUI());
            btnDepartamentos.addActionListener(e -> new DepartamentoUI());
            btnReportes.addActionListener(e -> new ReporteUI());
            btnSalir.addActionListener(e -> System.exit(0));
        });
    }
}




