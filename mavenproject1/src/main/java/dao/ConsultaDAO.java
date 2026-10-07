package dao;

import entidades.Consulta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaDAO {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        return emf.createEntityManager();
    }

    public void agendar(Consulta consulta) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(consulta);
            em.getTransaction().commit();
            System.out.println("Consulta agendada com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Consulta> listarTodas() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Consulta c", Consulta.class).getResultList();
        } finally {
            em.close();
        }
    }
}