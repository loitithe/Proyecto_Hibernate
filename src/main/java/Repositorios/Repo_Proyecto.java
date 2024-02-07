package Repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.Entidades.Proyecto;
import com.example.Entidades.Proyecto_Empleado;

public class Repo_Proyecto implements Repositorio<Proyecto> {

    private Session session;

    public Repo_Proyecto(Session session) {
        this.session = session;
    }

    @Override
    public void guardar(Proyecto t) {
        Transaction trx = this.session.beginTransaction();
        session.save(t);
        trx.commit();
    }

    @Override
    public List<Proyecto> listarTodos() {
        Transaction trx = this.session.beginTransaction();
        List<Proyecto> lista_Proyectos = session.createQuery("From Proyecto").getResultList();
        trx.commit();
        return lista_Proyectos;
    }

    @Override
    public void actualizar(Proyecto t) {
        Transaction trx = this.session.beginTransaction();
        session.update(t);
        trx.commit();
    }

    @Override
    public void eliminar(Proyecto t) {
        Transaction trx = this.session.beginTransaction();
        session.delete(t);
        trx.commit();
    }

    public Proyecto buscarProyecto(int id) {
        for (Proyecto p : listarTodos()) {
            if (p.getId_proyecto() == (id)) {
                return p;
            }
        }
        return null;

    }

    public boolean existeProyecto(int id_proyecto) {
        if (buscarProyecto(id_proyecto) == null) {
            return false;
        }
        return true;
    }

}
