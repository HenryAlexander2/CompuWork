package com.compuwork.service;

import com.compuwork.model.Empleado;
import com.compuwork.model.Departamento;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoService {

    private List<Empleado> empleados;

    public EmpleadoService() {
        this.empleados = new ArrayList<>();
    }

    // Agregar empleado
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // Actualizar empleado por id
    public void actualizarEmpleado(int id, Empleado empleadoActualizado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId() == id) {
                empleados.set(i, empleadoActualizado);
                return;
            }
        }
    }

    // Eliminar empleado por id
    public void eliminarEmpleado(int id) {
        empleados.removeIf(emp -> emp.getId() == id);
    }

    // Listar empleados
    public List<Empleado> listarEmpleados() {
        return empleados;
    }

    // Buscar empleado por id
    public Empleado buscarEmpleadoPorId(int id) {
        for (Empleado emp : empleados) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null; // si no lo encuentra
    }

    // Asignar empleado a un departamento
    public void asignarEmpleadoADepartamento(int idEmpleado, Departamento departamento) {
        Empleado emp = buscarEmpleadoPorId(idEmpleado);
        if (emp != null) {
            emp.setDepartamento(departamento);
        }
    }
}
