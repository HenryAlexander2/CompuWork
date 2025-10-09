package com.compuwork.service;

import com.compuwork.model.Departamento;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepartamentoService {

    // Instancia única (patrón Singleton)
    private static DepartamentoService instancia;

    // Lista interna de departamentos
    private final List<Departamento> departamentos;

    // Constructor privado
    private DepartamentoService() {
        departamentos = new ArrayList<>();
    }

    // Obtener la instancia única
    public static synchronized DepartamentoService getInstancia() {
        if (instancia == null) {
            instancia = new DepartamentoService();
        }
        return instancia;
    }

    // Agregar departamento
    public void agregarDepartamento(Departamento departamento) {
        if (departamento != null && !departamentos.contains(departamento)) {
            departamentos.add(departamento);
        }
    }

    // Listar departamentos (lista inmodificable)
    public List<Departamento> listarDepartamentos() {
        return Collections.unmodifiableList(departamentos);
    }

    // Buscar departamento por nombre
    public Departamento buscarPorNombre(String nombre) {
        for (Departamento depto : departamentos) {
            if (depto.getNombre().equalsIgnoreCase(nombre)) {
                return depto;
            }
        }
        return null;
    }

    // Eliminar departamento
    public void eliminarDepartamento(Departamento departamento) {
        departamentos.remove(departamento);
    }

    // Limpiar todos los departamentos
    public void limpiarDepartamentos() {
        departamentos.clear();
    }
}
