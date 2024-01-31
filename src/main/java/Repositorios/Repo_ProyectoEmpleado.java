package Repositorios;

import java.util.List;

import org.hibernate.Session;

import com.example.Entidades.Proyecto_Empleado;

public class Repo_ProyectoEmpleado implements Repositorio<Proyecto_Empleado> {
    private Session session;

    public Repo_ProyectoEmpleado(Session session) {
        this.session = session;
    }

    @Override
    public void guardar(Proyecto_Empleado t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public List<Proyecto_Empleado> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    @Override
    public void actualizar(Proyecto_Empleado t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(Proyecto_Empleado t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
