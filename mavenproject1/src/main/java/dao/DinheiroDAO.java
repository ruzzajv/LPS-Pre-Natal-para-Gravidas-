package dao;

import entidades.Dinheiro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DinheiroDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU");

    public void salvar(Dinheiro dinheiro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(dinheiro);
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