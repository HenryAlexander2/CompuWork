package com.compuwork.model;

import java.util.List;
import java.util.ArrayList;

public class Departamento {
    private int id;
    private String nombre;
    private List<Empleado> empleados;

    // Constructor
    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    // Métodos para gestionar empleados
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void removerEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public void removerEmpleadoPorId(int idEmpleado) {
        empleados.removeIf(emp -> emp.getId() == idEmpleado); // Usamos una expresión lambda para eliminar el empleado por ID
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void mostrarEmpleados() {
        System.out.println("--- Empleados del Departamento " + nombre + " ---");
        for (Empleado emp : empleados) {
            System.out.println("ID: " + emp.getId() + ", Nombre: " + emp.getNombre());
        }
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // 🔹 Sobrescribir toString() para mostrar el nombre del departamento
    @Override
    public String toString() {
        return nombre;
    }
}
