package com.compuwork.model;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Empleado {

    private List<Empleado> empleadosACargo;
    private List<Departamento> departamentosACargo;

    //  Constructor completo
    public Administrador(int id, String nombre, String cargo, double salario) {
        super(id, nombre, cargo, salario, TipoEmpleado.ADMINISTRADOR);
        this.empleadosACargo = new ArrayList<>();
        this.departamentosACargo = new ArrayList<>();
    }

    // Métodos básicos para empleados
    public void agregarEmpleado(Empleado empleado) {
        if (!empleadosACargo.contains(empleado)) {
            empleadosACargo.add(empleado);
        }
    }

    public void removerEmpleado(Empleado empleado) {
        empleadosACargo.remove(empleado);
    }

    //  Métodos básicos para departamentos
    public void agregarDepartamento(Departamento departamento) {
        if (!departamentosACargo.contains(departamento)) {
            departamentosACargo.add(departamento);
        }
    }

    public void removerDepartamento(Departamento departamento) {
        departamentosACargo.remove(departamento);
    }

    //  Crear un reporte (si la clase Reporte existe)
    public Reporte crearReporte(int idEmpleado, String evaluacion, float puntuacion) {
        return new Reporte(idEmpleado, evaluacion, puntuacion);
    }

    //  Getters
    public List<Empleado> getEmpleadosACargo() {
        return empleadosACargo;
    }

    public List<Departamento> getDepartamentosACargo() {
        return departamentosACargo;
    }

    //  Representación textual útil para combos o listados
    @Override
    public String toString() {
        return "Administrador: " + getNombre() + " (" + getCargo() + ")";
    }
}

