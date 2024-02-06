package Repositorios;

import java.util.List;

import javax.persistence.Query;

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

    public void buscarEmpleado(String dni) {
        Transaction trx = this.session.beginTransaction();

        Query query = session.createQuery("From Empleado where e.dni=:dni");
        query.setParameter("dni", dni);
        int elementos_afectados = query.executeUpdate();
        System.out.println("Se ha encontrado " + elementos_afectados + " coincidencias.");
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
