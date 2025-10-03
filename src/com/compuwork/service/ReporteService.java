package com.compuwork.service;

import com.compuwork.model.Empleado;
import com.compuwork.model.Departamento;
import com.compuwork.model.Reporte;

import java.util.ArrayList;
import java.util.List;

public class ReporteService {

    private List<Reporte> reportes;

    public ReporteService() {
        this.reportes = new ArrayList<>();
    }

    // Generar reporte individual de un empleado
    public Reporte generarReporteEmpleado(Empleado empleado, String metricas) {
        Reporte reporte = new Reporte(empleado, metricas);
        reportes.add(reporte);
        return reporte;
    }

    // Generar reporte de un departamento completo
    public List<Reporte> generarReporteDepartamento(Departamento departamento, String metricas) {
        List<Reporte> reportesDepartamento = new ArrayList<>();
        for (Empleado emp : departamento.getEmpleados()) {
            Reporte reporte = new Reporte(emp, metricas);
            reportes.add(reporte);
            reportesDepartamento.add(reporte);
        }
        return reportesDepartamento;
    }

    // Listar todos los reportes
    public List<Reporte> listarReportes() {
        return reportes;
    }

    // Buscar reportes por empleado
    public List<Reporte> buscarReportesPorEmpleado(int idEmpleado) {
        List<Reporte> resultado = new ArrayList<>();
        for (Reporte rep : reportes) {
            if (rep.getEmpleado().getId() == idEmpleado) {
                resultado.add(rep);
            }
        }
        return resultado;
    }
}
