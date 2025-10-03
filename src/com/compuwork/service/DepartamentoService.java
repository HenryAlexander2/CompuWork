package com.compuwork.service;

import com.compuwork.model.Departamento;
import com.compuwork.model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoService {

    private List<Departamento> departamentos;

    public DepartamentoService() {
        this.departamentos = new ArrayList<>();
    }

    // Agregar departamento
    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    // Actualizar departamento por id
    public void actualizarDepartamento(int id, Departamento departamentoActualizado) {
        for (int i = 0; i < departamentos.size(); i++) {
            if (departamentos.get(i).getId() == id) {
                departamentos.set(i, departamentoActualizado);
                return;
            }
        }
    }

    // Eliminar departamento por id
    public void eliminarDepartamento(int id) {
        departamentos.removeIf(dep -> dep.getId() == id);
    }

    // Listar departamentos
    public List<Departamento> listarDepartamentos() {
        return departamentos;
    }

    // Buscar departamento por id
    public Departamento buscarDepartamentoPorId(int id) {
        for (Departamento dep : departamentos) {
            if (dep.getId() == id) {
                return dep;
            }
        }
        return null; // si no lo encuentra
    }

    // Ver empleados de un departamento
    public List<Empleado> listarEmpleadosDeDepartamento(int idDepartamento) {
        Departamento dep = buscarDepartamentoPorId(idDepartamento);
        if (dep != null) {
            return dep.getEmpleados();
        }
        return new ArrayList<>();
    }
}
