package Repositorios;

import java.util.List;

import org.hibernate.Session;

import com.example.Entidades.Proyecto;

public class Repo_Proyecto implements Repositorio<Proyecto> {

    private Session session;

    public Repo_Proyecto(Session session) {
        this.session = session;
    }

    @Override
    public void guardar(Proyecto t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public List<Proyecto> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    @Override
    public void actualizar(Proyecto t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(Proyecto t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
