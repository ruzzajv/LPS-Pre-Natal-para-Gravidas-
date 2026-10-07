package dao;

import entidades.Atendente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AtendenteDAO {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        return emf.createEntityManager();
    }

    public void cadastrar(Atendente atendente) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(atendente);
            em.getTransaction().commit();
            System.out.println("Atendente cadastrado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Atendente> listar() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Atendente a", Atendente.class).getResultList();
        } finally {
            em.close();
        }
    }
}