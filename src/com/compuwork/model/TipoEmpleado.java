package com.compuwork.model;

public enum TipoEmpleado {
    FIJO("Empleado Fijo"),
    TEMPORAL("Empleado Temporal"),
    ADMINISTRADOR("Administrador");

    private final String descripcion;

    TipoEmpleado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // 🔹 Sobrescribimos toString para mostrar texto más legible en los menús
    @Override
    public String toString() {
        return descripcion;
    }
}
