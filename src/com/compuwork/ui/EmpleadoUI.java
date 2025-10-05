package com.compuwork.ui;

import com.compuwork.model.Empleado;
import com.compuwork.service.EmpleadoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EmpleadoUI extends JFrame {

    private EmpleadoService empleadoService;
    private JTextArea areaTexto;

    public EmpleadoUI() {
        empleadoService = new EmpleadoService();

        setTitle("Gestión de Empleados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Área de texto
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.LIGHT_GRAY);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar Empleado");
        JButton btnListar = new JButton("Listar Empleados");
        JButton btnSalir = new JButton("Cerrar Ventana");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnListar);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnAgregar.addActionListener(this::agregarEmpleado);
        btnListar.addActionListener(this::listarEmpleados);
        btnSalir.addActionListener(e -> dispose());
    }

    private void agregarEmpleado(ActionEvent e) {
        try {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del empleado:");
            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
                return;
            }

            String cargo = JOptionPane.showInputDialog(this, "Ingrese el cargo del empleado:");
            if (cargo == null || cargo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El cargo no puede estar vacío.");
                return;
            }

            String salarioStr = JOptionPane.showInputDialog(this, "Ingrese el salario del empleado:");
            double salario = Double.parseDouble(salarioStr);

            Empleado empleado = new Empleado(0, nombre, cargo, salario);
            empleadoService.agregarEmpleado(empleado);

            JOptionPane.showMessageDialog(this, "Empleado agregado con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Salario inválido. Intente nuevamente.");
        }
    }

    private void listarEmpleados(ActionEvent e) {
        areaTexto.setText("Lista de empleados:\n");
        for (Empleado emp : empleadoService.listarEmpleados()) {
            areaTexto.append(String.format(
                "- ID: %d | Nombre: %s | Cargo: %s | Salario: %.2f%n",
                emp.getId(), emp.getNombre(), emp.getCargo(), emp.getSalario()
            ));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmpleadoUI().setVisible(true));
    }
}
