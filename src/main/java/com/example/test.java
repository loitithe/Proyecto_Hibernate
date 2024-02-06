package com.example;

import org.hibernate.Session;

import com.example.Entidades.Categoria;
import com.example.Entidades.Datos_Profesionales;
import com.example.Entidades.Empleado;

import Repositorios.Repo_DatosProf;
import Repositorios.Repo_Empleado;
import Repositorios.Repo_Proyecto;
import Repositorios.Repo_ProyectoEmpleado;

import java.util.*;

public class test {

    private static Scanner sc;
    private static Session session = HibernateUtil.get().openSession();

    // Inicializar repositorios
    private static Repo_Empleado repo_Empleado = new Repo_Empleado(session);
    private static Repo_DatosProf repo_DatosProf = new Repo_DatosProf(session);
    private static Repo_Proyecto repo_Proyecto = new Repo_Proyecto(session);
    private static Repo_ProyectoEmpleado repo_ProyectoEmpleado = new Repo_ProyectoEmpleado(session);

    public static void main(String[] args) {
        System.out.println("Test");
        menuPrincipal();
        // Empleado empleado1 = new Empleado("2222", "jowei");
        // repo_Empleado.guardar(empleado1);
        System.out.println("Finalizando la conexion a MySQL");
        session.close();
        /**
         * Crear, borrar y modificar los datos de un empleado.
         * Crear, borrar y modificar los datos de un proyecto.
         * Asignar un empleado a un proyecto.
         * Indicar el fin de la participación de un empleado en un proyecto.
         * Cambiar el jefe de un proyecto.
         * Mostrar los datos de un proyecto (nombre, fechas, empleados…).
         * Mostrar los datos de los empleados que están en plantilla.
         * Mostrar los empleados que son jefes de proyecto.
         */

    }

    public static void menuPrincipal() {
        sc = new Scanner(System.in);
        int opcion = -1;
        try {
            do {
                System.out.println("1.Empleados\n2.Proyectos\n3.Asignar proyecto\4.Terminar participacion" +
                        "\n5.Cambiar jefe proyecto\n6.Mostrar datos proyecto\n7.Empleados plantilla\n8.Mostrar jefes proyecto\n0.Salir");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        menuEmpleados();
                        break;
                    case 2:
                        menuProyectos();
                        break;
                    case 3:
                        asignarProyecto();
                        break;
                    case 4:
                        terminaParticipacion();
                        break;
                    case 5:
                        cambiarJefe();
                        break;
                    case 6:
                        mostrarDatosProyecto();
                        break;
                    case 7:
                        mostrarPlantilla();
                        break;
                    case 8:
                        mostrarJefeProtecto();
                        break;
                    default:
                        break;
                }
            } while (opcion != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void mostrarJefeProtecto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarJefeProtecto'");
    }

    private static void mostrarPlantilla() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarPlantilla'");
    }

    private static void mostrarDatosProyecto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarDatosProyecto'");
    }

    private static void cambiarJefe() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarJefe'");
    }

    private static void terminaParticipacion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'terminaParticipacion'");
    }

    private static void asignarProyecto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarProyecto'");
    }

    private static void menuProyectos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'menuProyectos'");
    }

    private static void menuEmpleados() {
        int opcion = -1;
        do {
            System.out.println("1.Crear\n2.Borrar\n3.Modificar\n0.Atras");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Empleado empleado = crearEmpleado();
                    repo_Empleado.guardar(empleado);
                    System.out.println("El empleado sera de plantilla?\nS / N");
                    String opt = sc.next().trim().toUpperCase();
                    if (opt.equals("S")) {
                        Datos_Profesionales datos_Profesionales = crerDatosProfesionales();
                        empleado.setDatos_Profesionales(datos_Profesionales);
                        repo_DatosProf.guardar(datos_Profesionales);
                    }

                    break;
                case 2:
                    repo_Empleado.eliminar(buscarEmpleado());
                    break;
                case 3:

                    break;
                case 4:
                    menuPrincipal();
                    break;
                default:
                    break;
            }
        } while (opcion != 0);

    }

    private static Empleado buscarEmpleado() {
        String dni = pedirString("Introduce el DNI del empleado a borrar");
        for (Empleado e : repo_Empleado.listarTodos()) {
            if (e.getDni().equals(dni)) {
                return e;
            }
        }
        return null;
    }

    private static Empleado crearEmpleado() {
        Empleado empleado = new Empleado();
        String dni = pedirString("Introduce DNI :");
        if (repo_Empleado.buscarEmpleado(dni) == null) {
            String nombre = pedirString("Introduce el nombre :");
            empleado.setDni(dni);
            empleado.setNombre(nombre);
        } else {
            System.out.println("El dni ya existe");
            crearEmpleado();
        }

        return empleado;
    }

    private static Datos_Profesionales crerDatosProfesionales() {
        Datos_Profesionales datos_Profesionales = new Datos_Profesionales();
        double sueldo_bruto = pedirDouble("Introduce el sueldo bruto");
        datos_Profesionales.setSueldo_bruto(sueldo_bruto);
        switch (pedirCategoria()) {
            case 1:
                datos_Profesionales.setCategoria(Categoria.A);
                break;
            case 2:
                datos_Profesionales.setCategoria(Categoria.B);
                break;
            case 3:
                datos_Profesionales.setCategoria(Categoria.C);
                break;
            case 4:
                datos_Profesionales.setCategoria(Categoria.D);
                break;
            default:
                break;
        }
        return datos_Profesionales;
    }

    private static int pedirCategoria() {
        int categoria = -1;
        do {
            System.out.println("Elige una categoria");
            System.out.println("\n1. A\n2. B\n3. C\n4. D");
            try {
                categoria = Integer.parseInt(sc.next());

            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Introduce una opcion valida");
            }
        } while (categoria > 4 || categoria < 1);
        return categoria;
    }

    private static double pedirDouble(String mensaje) {
        System.out.println(mensaje);
        double entrada = -1;
        do {
            try {
                entrada = Double.parseDouble(sc.next());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Debes introducir un valor numerico");
            }

        } while (entrada < 0);
        return entrada;
    }

    public static String pedirString(String mensaje) {
        System.out.println(mensaje);
        String entrada = "";
        do {
            try {
                entrada = sc.next();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Debes introducir un string");
            }
        } while (entrada.equals(""));

        return entrada;
    }

}
