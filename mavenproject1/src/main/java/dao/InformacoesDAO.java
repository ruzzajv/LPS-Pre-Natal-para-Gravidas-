package dao;

import entidades.Informacoes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InformacoesDAO {
    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";
    private EntityManagerFactory emf;

    public InformacoesDAO() {
        this.emf = Persistence.createEntityManagerFactory(PU);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void salvar(Informacoes info) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(info);
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

    public List<Informacoes> listarTodas() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT i FROM Informacoes i ORDER BY i.idInformacao DESC", Informacoes.class).getResultList();
        } finally {
            em.close();
        }
    }
}