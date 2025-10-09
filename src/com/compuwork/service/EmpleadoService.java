package com.compuwork.service;

import com.compuwork.model.Empleado;
import com.compuwork.model.Departamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpleadoService {

    // Instancia única (patrón Singleton)
    private static EmpleadoService instancia;

    // Lista interna de empleados
    private final List<Empleado> empleados;

    // Constructor privado
    private EmpleadoService() {
        empleados = new ArrayList<>();
    }

    // Obtener la instancia única (hilo seguro)
    public static synchronized EmpleadoService getInstancia() {
        if (instancia == null) {
            instancia = new EmpleadoService();
        }
        return instancia;
    }

    // Agregar empleado
    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null && buscarEmpleadoPorId(empleado.getId()) == null) {
            empleados.add(empleado);
        }
    }

    // Actualizar empleado por ID
    public void actualizarEmpleado(int id, Empleado empleadoActualizado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId() == id) {
                empleados.set(i, empleadoActualizado);
                return;
            }
        }
    }

    // Eliminar empleado por ID
    public void eliminarEmpleado(int id) {
        empleados.removeIf(emp -> emp.getId() == id);
    }

    // Listar empleados (lista inmodificable)
    public List<Empleado> listarEmpleados() {
        return Collections.unmodifiableList(empleados);
    }

    // Buscar empleado por ID
    public Empleado buscarEmpleadoPorId(int id) {
        for (Empleado emp : empleados) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    // Asignar empleado a un departamento
    public void asignarEmpleadoADepartamento(int idEmpleado, Departamento departamento) {
        Empleado empleado = buscarEmpleadoPorId(idEmpleado);
        if (empleado != null && departamento != null) {
            empleado.setDepartamento(departamento);
        }
    }

    // Limpiar todos los empleados
    public void limpiarEmpleados() {
        empleados.clear();
    }
}

