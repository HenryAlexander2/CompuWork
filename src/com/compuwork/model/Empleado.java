package com.compuwork.model;

public class Empleado {
    // Atributos
    private int id;
    private String nombre;
    private String cargo;
    private double salario;
    private TipoEmpleado tipo;

    // Constructor principal (id requerido)
    public Empleado(int id) {
        this.id = id;
        this.nombre = "";
        this.cargo = "";
        this.salario = 0.0;
        this.tipo = TipoEmpleado.FIJO; // Valor por defecto
    }

    // Constructor completo
    public Empleado(int id, String nombre, String cargo, double salario, TipoEmpleado tipo) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.tipo = tipo;
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
}