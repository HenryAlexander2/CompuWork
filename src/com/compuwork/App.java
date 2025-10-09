package com.compuwork;

import com.compuwork.ui.DepartamentoUI;
import com.compuwork.ui.EmpleadoUI;
import com.compuwork.ui.ReporteUI;
import com.compuwork.service.DepartamentoService;

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

            //  Usar la instancia Singleton del servicio
            DepartamentoService departamentoService = DepartamentoService.getInstancia();

            // --- Botón "Gestión de Empleados" ---
            btnEmpleados.addActionListener(e -> {
                // Verificar si hay al menos un departamento antes de abrir EmpleadoUI
                if (departamentoService.listarDepartamentos().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            menu,
                            "No existen departamentos registrados.\nDebe crear al menos uno antes de gestionar empleados.",
                            "Advertencia",
                            JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    //  Se debe llamar a setVisible(true) para mostrar la ventana
                    new EmpleadoUI().setVisible(true);
                }
            });

            // --- Botón "Gestión de Departamentos" ---
            btnDepartamentos.addActionListener(e -> new DepartamentoUI().setVisible(true));

            // --- Botón "Gestión de Reportes" ---
            btnReportes.addActionListener(e -> new ReporteUI().setVisible(true));

            // --- Botón "Salir" ---
            btnSalir.addActionListener(e -> System.exit(0));
        });
    }
}





