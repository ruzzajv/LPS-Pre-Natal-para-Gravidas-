package dao;

import entidades.Consulta;
import entidades.Gestante;
import entidades.Medico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaDAO {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";
    private EntityManagerFactory emf;

    public ConsultaDAO() {
        this.emf = Persistence.createEntityManagerFactory(PU);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void agendar(Consulta consulta) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(consulta);
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

    public void editar(Consulta consulta) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(consulta);
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
            Consulta consulta = em.find(Consulta.class, id);
            if (consulta != null) {
                em.remove(consulta);
                em.getTransaction().commit();
            } else {
                throw new Exception("Consulta não encontrada.");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public Consulta buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consulta.class, id);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public List<Consulta> listarTodas() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Consulta c", Consulta.class).getResultList();
        } finally {
            em.close();
        }
    }


    public Gestante buscarGestante(String termo) {
        EntityManager em = getEntityManager();
        try {
            List<Gestante> lista = em.createQuery(
                "SELECT g FROM Gestante g WHERE g.cpf = :termo OR LOWER(g.nome) LIKE LOWER(:nome)", Gestante.class)
                .setParameter("termo", termo.trim())
                .setParameter("nome", "%" + termo.trim() + "%")
                .getResultList();
            return lista.isEmpty() ? null : lista.get(0);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }


    public Medico buscarMedico(String termo) {
        EntityManager em = getEntityManager();
        try {
            List<Medico> lista = em.createQuery(
                "SELECT m FROM Medico m WHERE m.cpf = :termo OR m.crm = :termo OR LOWER(m.nome) LIKE LOWER(:nome)", Medico.class)
                .setParameter("termo", termo.trim())
                .setParameter("nome", "%" + termo.trim() + "%")
                .getResultList();
            return lista.isEmpty() ? null : lista.get(0);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}