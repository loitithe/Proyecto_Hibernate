package Repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.Entidades.Empleado;

public class Repo_Empleado implements Repositorio<Empleado> {
    private Session session;

    public Repo_Empleado(Session session) {
        this.session = session;
    }

    @Override
    public void guardar(Empleado t) {
        Transaction trx = this.session.beginTransaction();
        session.save(t);
        trx.commit();
    }

    @Override
    public List<Empleado> listarTodos() {
        Transaction trx = this.session.beginTransaction();
        List<Empleado> listaEmpleados = session.createQuery("From Empleado").getResultList();

        trx.commit();
        return listaEmpleados;
    }

    @Override
    public void actualizar(Empleado t) {
        Transaction trx = this.session.beginTransaction();
        session.update(t);
        trx.commit();
    }

    @Override
    public void eliminar(Empleado t) {
        Transaction trx = this.session.beginTransaction();
        session.save(t);
        trx.commit();
    }

}
