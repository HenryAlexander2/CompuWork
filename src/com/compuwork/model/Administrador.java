package com.compuwork.model;
// Clase Administrador hereda de Empleado
// y representa a un administrador en el sistema
// Esta clase puede contener atributos y métodos específicos para los administradores
import java.util.ArrayList;
import java.util.List;

public class Administrador extends Empleado {
    private List<Empleado> empleadosACargo;
    private List<Departamento> departamentosACargo;
    
    // Constructor completo
    public Administrador(int id, String nombre,  String cargo, double salario, TipoEmpleado tipo) {
        super(id, nombre, cargo, salario, TipoEmpleado.ADMINISTRADOR);
        this.empleadosACargo = new ArrayList<>();
        this.departamentosACargo = new ArrayList<>();
    }
    
    // Métodos básicos para empleados
    public void agregarEmpleado(Empleado empleado) {
        this.empleadosACargo.add(empleado);
    }
    
    public void removerEmpleado(Empleado empleado) {
        this.empleadosACargo.remove(empleado);
    }
    
    // Métodos básicos para departamentos
    public void agregarDepartamento(Departamento departamento) {
        this.departamentosACargo.add(departamento);
    }
    
    public void removerDepartamento(Departamento departamento) {
        this.departamentosACargo.remove(departamento);
    }
    
    // Método básico para reportes
    public Reporte crearReporte(int idEmpleado, String evaluacion, float puntuacion) {
        return new Reporte(idEmpleado, evaluacion, puntuacion);
    }
    
    // Getters básicos
    public List<Empleado> getEmpleadosACargo() {
        return this.empleadosACargo;
    }
    
    public List<Departamento> getDepartamentosACargo() {
        return this.departamentosACargo;
    }
}
