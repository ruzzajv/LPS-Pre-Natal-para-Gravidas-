package dao;

import entidades.Credito;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreditoDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU");

    public void salvar(Credito credito) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(credito);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}