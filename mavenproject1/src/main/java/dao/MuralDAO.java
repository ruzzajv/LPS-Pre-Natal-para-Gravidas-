package dao;

import entidades.Mural;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MuralDAO {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";
    private EntityManagerFactory emf;

    public MuralDAO() {
        this.emf = Persistence.createEntityManagerFactory(PU);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void salvar(Mural mural) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mural);
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

    public List<Mural> listarTodos() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT m FROM Mural m ORDER BY m.idPostMural DESC", Mural.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Mural buscar(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mural.class, id);
        } finally {
            em.close();
        }
    }

    public void editar(Mural mural) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(mural);
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

    public void excluir(Long id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Mural mural = em.find(Mural.class, id);
            if (mural != null) {
                em.remove(mural);
            }
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
