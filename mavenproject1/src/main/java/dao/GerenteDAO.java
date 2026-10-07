package dao;

import entidades.Gerente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenteDAO {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        return emf.createEntityManager();
    }

    public void cadastrar(Gerente gerente) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(gerente);
            em.getTransaction().commit();
            System.out.println("Gerente cadastrado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Gerente> listar() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT g FROM Gerente g", Gerente.class).getResultList();
        } finally {
            em.close();
        }
    }
}