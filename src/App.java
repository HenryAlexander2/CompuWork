package master.java.model;

public class App {
    public static void main(String[] args) {
        // 1. Crear datos de prueba
        Departamento departamentoTI = new Departamento(1, "Tecnología");
        
        Empleado empleado1 = new Empleado(101, "Ana López", "Desarrolladora", 4500.0, TipoEmpleado.FIJO);
        Empleado empleado2 = new Empleado(102, "Carlos Ruiz", "Diseñador", 3800.0, TipoEmpleado.TEMPORAL);
        
        // 2. Asignar empleados al departamento
        departamentoTI.agregarEmpleado(empleado1);
        departamentoTI.agregarEmpleado(empleado2);
        
        // 3. Generar reporte de desempeño
        ReporteDesempeño reporte = new ReporteDesempeño(
            empleado1.getId(), 
            "Excelente desempeño en Q1", 
            9.5f
        );
        
        // 4. Mostrar resumen en consola
        System.out.println("=== DATOS INICIALES DEL SISTEMA ===");
        System.out.println("\nDepartamento: " + departamentoTI.getNombre());
        System.out.println("Empleados:");
        departamentoTI.getEmpleados().forEach(emp -> 
            System.out.printf(
                "  - %s (ID: %d) | Salario: $%.2f%n",
                emp.getNombre(), emp.getId(), emp.getSalario()
            )
        );
        System.out.println("\nReporte generado:");
        System.out.println(reporte.obtenerReporteFormateado());
        
        // 5. Iniciar interfaz gráfica (opcional)
        System.out.println("\n✅ Modelo cargado. Ejecuta com.compuwork.ui.App para la interfaz gráfica.");
    }
}