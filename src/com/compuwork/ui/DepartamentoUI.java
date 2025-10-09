package com.compuwork.ui;

import com.compuwork.model.Departamento;
import com.compuwork.service.DepartamentoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartamentoUI extends JFrame {

    private DepartamentoService departamentoService;
    private JTextArea areaTexto;

    public DepartamentoUI() {
        departamentoService = DepartamentoService.getInstancia();
        inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        setTitle("Gestión de Departamentos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Área de texto (para mostrar los departamentos)
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.LIGHT_GRAY);
        panel.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

       // Panel inferior con todos los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));

        
        JButton btnListar = new JButton("Listar Departamentos");
        JButton btnAgregar = new JButton("Agregar Departamento");
        JButton btnAtras = new JButton("Atrás");

        
        panelBotones.add(btnListar);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnAtras);

        panel.add(panelBotones, BorderLayout.SOUTH);



        

        // Acciones de los botones
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarDepartamentos();
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDepartamento();
            }
        });

        btnAtras.addActionListener(e -> dispose()); // Cierra la ventana actual;

        add(panel);
        setVisible(true);
    }

    private void listarDepartamentos() {
        areaTexto.setText("Departamentos registrados:\n");
        for (Departamento d : departamentoService.listarDepartamentos()) {
            areaTexto.append("- " + d.getNombre() + "\n");
        }
    }

    private void agregarDepartamento() {
    String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del departamento:");
    if (nombre != null && !nombre.trim().isEmpty()) {
        Departamento nuevoDepartamento = new Departamento(nombre);
        departamentoService.agregarDepartamento(nuevoDepartamento);
        JOptionPane.showMessageDialog(this, "Departamento agregado con éxito.");
        listarDepartamentos(); // Actualiza el área de texto
    } else {
        JOptionPane.showMessageDialog(this, "Nombre inválido.");
    }
}



// Prueba individual
    public static void main(String[] args) {
        departamentoService = DepartamentoService.getInstancia();

    }
}
