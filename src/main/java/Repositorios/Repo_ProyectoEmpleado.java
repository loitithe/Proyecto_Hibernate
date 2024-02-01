package Repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.Entidades.Proyecto_Empleado;

public class Repo_ProyectoEmpleado implements Repositorio<Proyecto_Empleado> {
    private Session session;

    public Repo_ProyectoEmpleado(Session session) {
        this.session = session;
    }

    @Override
    public void guardar(Proyecto_Empleado t) {
        Transaction trx = this.session.beginTransaction();
        session.save(t);
        trx.commit();
    }

    @Override
    public List<Proyecto_Empleado> listarTodos() {
        Transaction trx = this.session.beginTransaction();
        List<Proyecto_Empleado> lista_ProyectoEmpleado = session.createQuery("From asig_proyecto").getResultList();
        trx.commit();
        return lista_ProyectoEmpleado;
    }

    @Override
    public void actualizar(Proyecto_Empleado t) {
        Transaction trx = this.session.beginTransaction();
        session.update(t);
        trx.commit();
    }

    @Override
    public void eliminar(Proyecto_Empleado t) {
        Transaction trx = this.session.beginTransaction();
        session.save(t);
        trx.commit();
    }

}
