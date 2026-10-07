package dao;

import entidades.Informacoes; // Ou Comunidade
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ComunidadeDAO {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        return emf.createEntityManager();
    }

    public void salvar(Informacoes info) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(info);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}