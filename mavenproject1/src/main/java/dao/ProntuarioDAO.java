package dao;

import entidades.Prontuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.NoResultException;

public class ProntuarioDAO {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";
    private EntityManagerFactory emf;


    public ProntuarioDAO() {
        this.emf = Persistence.createEntityManagerFactory(PU);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void salvar(Prontuario prontuario) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(prontuario);
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

    public void editar(Prontuario prontuario) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(prontuario); 
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

    public Prontuario buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Prontuario.class, id);
        } finally {
            em.close();
        }
    }

    public Prontuario buscarPorCpfPaciente(String cpfPaciente) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Prontuario p WHERE p.cpfPaciente = :cpf", Prontuario.class)
                     .setParameter("cpf", cpfPaciente)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null; 
        } finally {
            em.close();
        }
    }
}