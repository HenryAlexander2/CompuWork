package com.compuwork.model;

public class Empleado {
    // Atributos
    private int id;
    private String nombre;
    private String cargo;
    private double salario;
    private TipoEmpleado tipo;
    private Departamento departamento; // Asociación con Departamento

    // Constructor principal (id requerido)
    public Empleado(int id) {
        this.id = id;
        this.nombre = "";
        this.cargo = "";
        this.salario = 0.0;
        this.tipo = TipoEmpleado.FIJO; // Valor por defecto
        this.departamento = null; // Inicialmente sin asignar
    }

    // Constructor completo
    public Empleado(int id, String nombre, String cargo, double salario, TipoEmpleado tipo) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.tipo = tipo;
        this.departamento = null; // Inicialmente sin asignar
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCargo() {
        return this.cargo;
    }

    public double getSalario() {
        return this.salario;
    }

    public TipoEmpleado getTipo() {
        return this.tipo;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setTipo(TipoEmpleado tipo) {
        this.tipo = tipo;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    // 🔹 Sobrescribir toString() para mostrar información útil
    @Override
    public String toString() {
        return String.format(
            "ID: %d | Nombre: %s | Cargo: %s | Salario: %.2f | Tipo: %s | Departamento: %s",
            id,
            nombre,
            cargo,
            salario,
            tipo != null ? tipo.name() : "N/A",
            departamento != null ? departamento.getNombre() : "Sin asignar"
        );
    }
}
