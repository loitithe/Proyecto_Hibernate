package com.example;

import org.hibernate.Session;

import com.example.Entidades.Empleado;

import Repositorios.Repo_Empleado;

public class test {

    public static void main(String[] args) {
        System.out.println("Test");
        Session session = HibernateUtil.get().openSession();
        System.out.println("Finalizando la conexion a MySQL");

        Repo_Empleado repo_Empleado = new Repo_Empleado(session);

        Empleado empleado1 = new Empleado("2222", "jowei");
        repo_Empleado.guardar(empleado1);
        session.close();
    }
}
