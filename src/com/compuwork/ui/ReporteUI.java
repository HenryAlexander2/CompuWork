package com.compuwork.ui;

import com.compuwork.model.Reporte;
import com.compuwork.service.ReporteService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReporteUI extends JFrame {

    private ReporteService reporteService;
    private JTextArea areaTexto;

    public ReporteUI() {
        reporteService = new ReporteService();
        inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        setTitle("Gestión de Reportes");
        setSize(450, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Área de texto
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.LIGHT_GRAY);
        panel.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel();
        JButton btnListar = new JButton("Listar Reportes");
        JButton btnAgregar = new JButton("Agregar Reporte");
        panelBotones.add(btnListar);
        panelBotones.add(btnAgregar);
        panel.add(panelBotones, BorderLayout.SOUTH);

        // Acciones
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarReportes();
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarReporte();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void listarReportes() {
        areaTexto.setText("Reportes registrados:\n");
        for (Reporte r : reporteService.listarReportes()) {
            areaTexto.append(
                String.format("Empleado ID: %d | Puntuación: %.1f | %s\n",
                    r.getIdEmpleado(), r.getPuntuacion(), r.getEvaluacion())
            );
        }
    }

    private void agregarReporte() {
        try {
            int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del empleado:"));
            String evaluacion = JOptionPane.showInputDialog(this, "Ingrese la evaluación:");
            float puntuacion = Float.parseFloat(JOptionPane.showInputDialog(this, "Ingrese la puntuación (0-10):"));

            Reporte nuevo = new Reporte(idEmpleado, evaluacion, puntuacion);
            reporteService.listarReportes().add(nuevo);

            JOptionPane.showMessageDialog(this, "Reporte agregado correctamente.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: formato de número inválido.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new ReporteUI();
    }
}
