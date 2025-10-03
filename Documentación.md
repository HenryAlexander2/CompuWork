1. Modelo definido (package model)

Los servicios trabajan sobre las clases del modelo.
Ejemplo:

EmpleadoService → necesita Empleado, EmpleadoPermanente, EmpleadoTemporal.

DepartamentoService → necesita Departamento y la relación con Empleado.

ReporteService → necesita Empleado, Departamento y Reporte.

Es decir, los service van a usar las clases del paquete model para procesar la lógica.

2. Operaciones básicas (lógica de negocio)

Cada servicio define métodos que manipulan las entidades.

EmpleadoService

agregarEmpleado()

actualizarEmpleado()

eliminarEmpleado()

listarEmpleados()

asignarEmpleadoADepartamento()

DepartamentoService

crearDepartamento()

modificarDepartamento()

eliminarDepartamento()

listarDepartamentos()

obtenerEmpleadosPorDepartamento()

ReporteService

generarReporteEmpleado()

generarReporteDepartamento()

exportarReporte()

3. Estructura del código en el paquete service

Las clases de service necesitan:

Atributos internos para guardar la información (en este ejercicio sencillo pueden ser List<Empleado> o List<Departamento> en memoria, no base de datos).

Métodos públicos para exponer las operaciones que vimos arriba.

Uso de colecciones (ArrayList, HashMap, etc.) para manejar registros temporalmente.