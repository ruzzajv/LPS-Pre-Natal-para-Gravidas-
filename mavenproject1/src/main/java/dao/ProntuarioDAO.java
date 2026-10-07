package dao;

import entidades.Prontuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProntuarioDAO {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        return emf.createEntityManager();
    }

    public void salvar(Prontuario prontuario) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(prontuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Prontuario buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Prontuario.class, id);
        } finally {
            em.close();
        }
    }
}