package com.compuwork.service;

import com.compuwork.model.Empleado;
import com.compuwork.model.Departamento;
import com.compuwork.model.Reporte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReporteService {

    // Instancia única (Singleton)
    private static ReporteService instancia;

    // Lista de reportes (almacenamiento en memoria)
    private final List<Reporte> reportes;

    // Constructor privado
    private ReporteService() {
        this.reportes = new ArrayList<>();
    }

    // Obtener instancia global (hilo seguro)
    public static synchronized ReporteService getInstancia() {
        if (instancia == null) {
            instancia = new ReporteService();
        }
        return instancia;
    }

    // Generar reporte individual de un empleado
    public Reporte generarReporteEmpleado(Empleado empleado, String evaluacion, float puntuacion) {
        if (empleado == null || evaluacion == null || evaluacion.isBlank()) {
            throw new IllegalArgumentException("Datos inválidos para generar el reporte");
        }

        Reporte reporte = new Reporte(empleado.getId(), evaluacion, puntuacion);
        reportes.add(reporte);
        return reporte;
    }

    // Generar reportes para todos los empleados de un departamento
    public List<Reporte> generarReporteDepartamento(Departamento departamento, String evaluacion, float puntuacion) {
        if (departamento == null || departamento.getEmpleados() == null) {
            throw new IllegalArgumentException("El departamento o su lista de empleados es nula");
        }

        List<Reporte> reportesDepartamento = new ArrayList<>();
        for (Empleado emp : departamento.getEmpleados()) {
            Reporte reporte = new Reporte(emp.getId(), evaluacion, puntuacion);
            reportes.add(reporte);
            reportesDepartamento.add(reporte);
        }
        return reportesDepartamento;
    }

    // Listar todos los reportes (lista inmodificable)
    public List<Reporte> listarReportes() {
        return Collections.unmodifiableList(reportes);
    }

    // Buscar reportes por ID de empleado
    public List<Reporte> buscarReportesPorEmpleado(int idEmpleado) {
        List<Reporte> resultado = new ArrayList<>();
        for (Reporte rep : reportes) {
            if (rep.getIdEmpleado() == idEmpleado) {
                resultado.add(rep);
            }
        }
        return resultado;
    }

    // Eliminar reportes por ID de empleado
    public void eliminarReportesPorEmpleado(int idEmpleado) {
        reportes.removeIf(rep -> rep.getIdEmpleado() == idEmpleado);
    }

    // Limpiar todos los reportes (útil para pruebas o reinicio del sistema)
    public void limpiarReportes() {
        reportes.clear();
    }
}

