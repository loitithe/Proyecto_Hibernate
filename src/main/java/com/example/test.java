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
    private Repo_Empleado repo_Empleado = new Repo_Empleado(session);
    private Repo_DatosProf repo_DatosProf = new Repo_DatosProf(session);
    private Repo_Proyecto repo_Proyecto = new Repo_Proyecto(session);
    private Repo_ProyectoEmpleado repo_ProyectoEmpleado = new Repo_ProyectoEmpleado(session);

    public static void main(String[] args) {
        System.out.println("Test");

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

    public void menuPrincipal() {
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
                        mostrarDatosProyecto();
                        break;
                    default:
                        break;
                }
            } while (opcion != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void mostrarPlantilla() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarPlantilla'");
    }

    private void mostrarDatosProyecto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarDatosProyecto'");
    }

    private void cambiarJefe() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarJefe'");
    }

    private void terminaParticipacion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'terminaParticipacion'");
    }

    private void asignarProyecto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarProyecto'");
    }

    private void menuProyectos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'menuProyectos'");
    }

    private void menuEmpleados() {
        int opcion = -1;
        do {
            System.out.println("1.Crear\n2.Borrar\n3.Modificar");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:

                    repo_Empleado.guardar(crearEmpleado());
                    break;
                case 2:
                    repo_Empleado.eliminar(buscarEmpleado());
                    break;
                case 3:

                    break;
                default:
                    break;
            }
        } while (opcion != 0);

    }

    private Empleado buscarEmpleado() {
        String dni = pedirString("Introduce el DNI del empleado a borrar");
        for (Empleado e : repo_Empleado.listarTodos()) {
            if (e.getDni().equals(dni)) {
                return e;
            }
        }
        return null;
    }

    private Empleado crearEmpleado() {
        String dni = pedirString("Introduce DNI :");
        String nombre = pedirString("Introduce el nombre :");
        Empleado empleado = new Empleado(dni, nombre);
        System.out.println("El empleado sera de plantilla?\nS / N");
        String opt = sc.next().trim().toUpperCase();
        if (opt.equals("S")) {
            empleado.setDatos_Profesionales(crerDatosProfesionales());
        }
        return empleado;
    }

    private Datos_Profesionales crerDatosProfesionales() {
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

    private int pedirCategoria() {
        int categoria = -1;
        do {
            System.out.println("Elige una categoria");
            System.out.println("\n1. A\n2. B\n3. C\n4. D");
            try {
                categoria = sc.nextInt();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Introduce una opcion valida");
            }
        } while (categoria != 1 || categoria != 2 || categoria != 3 || categoria != 4);
        return categoria;
    }

    private double pedirDouble(String mensaje) {
        System.out.println(mensaje);
        double entrada = -1;
        do {
            try {
                entrada = sc.nextDouble();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Debes introducir un valor numerico");
            }
        } while (entrada != -1);

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
        } while (!entrada.equals(""));

        return entrada;
    }

}
