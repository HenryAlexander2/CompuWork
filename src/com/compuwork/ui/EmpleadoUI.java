package com.compuwork.ui;

import com.compuwork.model.Departamento;
import com.compuwork.model.Empleado;
import com.compuwork.model.TipoEmpleado;
import com.compuwork.service.DepartamentoService;
import com.compuwork.service.EmpleadoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class EmpleadoUI extends JFrame {

    private final EmpleadoService empleadoService;
    private final DepartamentoService departamentoService;
    private JTextArea areaTexto;

    public EmpleadoUI() {
        empleadoService = EmpleadoService.getInstancia();
        departamentoService = DepartamentoService.getInstancia();

        setTitle("Gestión de Empleados");
        setSize(500, 350);
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

        // 👇 Aquí faltaba esto
        setVisible(true);
    }

    private void agregarEmpleado(ActionEvent e) {
        try {
            // Verificar si existen departamentos
            List<Departamento> departamentos = departamentoService.listarDepartamentos();
            if (departamentos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay departamentos disponibles. Debe crear al menos uno.");
                return;
            }

            // Seleccionar el departamento
            Departamento departamentoSeleccionado = (Departamento) JOptionPane.showInputDialog(
                    this,
                    "Seleccione el departamento:",
                    "Asignar Departamento",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    departamentos.toArray(),
                    departamentos.get(0)
            );

            if (departamentoSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "No se seleccionó ningún departamento.");
                return;
            }

            // Ingresar datos del empleado
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

            // Seleccionar tipo de empleado (Fijo o Temporal)
            TipoEmpleado tipo = (TipoEmpleado) JOptionPane.showInputDialog(
                    this,
                    "Seleccione el tipo de empleado:",
                    "Tipo de Empleado",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    TipoEmpleado.values(),
                    TipoEmpleado.FIJO
            );

            if (tipo == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de empleado.");
                return;
            }

            // Crear y asignar
            Empleado empleado = new Empleado(0, nombre, cargo, salario, tipo);
            empleado.setDepartamento(departamentoSeleccionado);
            empleadoService.agregarEmpleado(empleado);
            departamentoSeleccionado.agregarEmpleado(empleado);

            JOptionPane.showMessageDialog(this, "Empleado agregado con éxito al departamento " + departamentoSeleccionado.getNombre());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Salario inválido. Intente nuevamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar el empleado: " + ex.getMessage());
        }
    }

    private void listarEmpleados(ActionEvent e) {
        areaTexto.setText("Lista de empleados:\n\n");
        List<Empleado> empleados = empleadoService.listarEmpleados();

        if (empleados.isEmpty()) {
            areaTexto.append("No hay empleados registrados.\n");
            return;
        }

        for (Empleado emp : empleados) {
            areaTexto.append(String.format(
                    "- ID: %d | Nombre: %s | Cargo: %s | Salario: %.2f | Tipo: %s | Depto: %s%n",
                    emp.getId(),
                    emp.getNombre(),
                    emp.getCargo(),
                    emp.getSalario(),
                    emp.getTipo(), // nombre del método en clase Empleado
                    emp.getDepartamento() != null ? emp.getDepartamento().getNombre() : "Sin asignar"
            ));
        }
    }
}
