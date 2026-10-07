package dao;

import entidades.Gestante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestanteDAO {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        return emf.createEntityManager();
    }

    public void cadastrar(Gestante gestante) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(gestante);
            em.getTransaction().commit();
            System.out.println("Gestante cadastrada com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Gestante> listar() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT g FROM Gestante g", Gestante.class).getResultList();
        } finally {
            em.close();
        }
    }
}