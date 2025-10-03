package com.compuwork.model;
/**
 - Clase ReporteDesempeño
 - Esta clase representa un reporte de desempeño en el sistema.
 - Puede contener atributos y métodos relacionados con el reporte de desempeño por empleado.
 */
public class ReporteDesempeño {
    // Atributos
    private final int idEmpleado;
    private String evaluacion;
    private float puntuacion;
    
    // Constructor
    public ReporteDesempeño(int idEmpleado, String evaluacion, float puntuacion) {
        this.idEmpleado = idEmpleado;
        this.evaluacion = evaluacion;
        this.puntuacion = validarPuntuacion(puntuacion);
    }
    
    // Validación de puntuación (0-10)
    private float validarPuntuacion(float puntuacion) {
        if (puntuacion < 0 || puntuacion > 10) {
            throw new IllegalArgumentException("La puntuación debe estar entre 0 y 10");
        }
        return puntuacion;
    }
    
    // Getters
    public int getIdEmpleado() {
        return idEmpleado;
    }
    
    public String getEvaluacion() {
        return evaluacion;
    }
    
    public float getPuntuacion() {
        return puntuacion;
    }
    
    // Setters protegidos (solo para Administrador)
    protected void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }
    
    protected void setPuntuacion(float puntuacion) {
        this.puntuacion = validarPuntuacion(puntuacion);
    }
    
    // Método para obtener reporte formateado
    public String obtenerReporteFormateado() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("╔══════════════════════════════╗\n");
        reporte.append("║      REPORTE DE DESEMPEÑO     ║\n");
        reporte.append("╠══════════════════════════════╣\n");
        reporte.append(String.format("║ ID Empleado: %-17d ║\n", idEmpleado));
        reporte.append(String.format("║ Puntuación: %-18.1f ║\n", puntuacion));
        reporte.append("╠══════════════════════════════╣\n");
        reporte.append("║ EVALUACIÓN:                  ║\n");
        
        // Dividir la evaluación en líneas de máximo 28 caracteres
        String[] lineas = dividirTexto(evaluacion, 28);
        for (String linea : lineas) {
            reporte.append(String.format("║ %-28s ║\n", linea));
        }
        
        reporte.append("╚══════════════════════════════╝");
        return reporte.toString();
    }
    
    // Método auxiliar para dividir texto en líneas
    private String[] dividirTexto(String texto, int maxLength) {
        return texto.split("(?<=\\G.{" + maxLength + "})");
    }
    
    @Override
    public String toString() {
        return String.format(
            "ReporteDesempeño[idEmpleado=%d, puntuacion=%.1f, evaluacion=%s]",
            idEmpleado, puntuacion, evaluacion
        );
    }
}
