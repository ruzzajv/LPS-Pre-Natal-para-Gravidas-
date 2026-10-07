package dao;

import entidades.Medico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MedicoDAO {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        return emf.createEntityManager();
    }

    public void cadastrar(Medico medico) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(medico);
            em.getTransaction().commit();
            System.out.println("Médico cadastrado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Medico> listar() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT m FROM Medico m", Medico.class).getResultList();
        } finally {
            em.close();
        }
    }
}