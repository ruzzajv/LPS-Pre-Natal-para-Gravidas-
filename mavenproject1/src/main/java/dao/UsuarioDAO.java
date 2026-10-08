package dao;

import entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioDAO {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";
    private EntityManagerFactory emf;

    public UsuarioDAO() {
        this.emf = Persistence.createEntityManagerFactory(PU);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void salvar(Usuario usuario) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
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

    public void editar(Usuario usuario) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(usuario);
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
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
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
    
  public Usuario buscarObjetoPorCpf(String cpf) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.cpf = :cpf", Usuario.class)
                     .setParameter("cpf", cpf)
                     .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

   
    public String buscarNomePorCpf(String cpf) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u.nome FROM Usuario u WHERE u.cpf = :cpf", String.class)
                     .setParameter("cpf", cpf)
                     .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    // Exclusão por CPF utilizando o mesmo EntityManager ativo na transação
    public void excluirPorCpf(String cpf) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            
            Usuario usuario = null;
            try {
                usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.cpf = :cpf", Usuario.class)
                          .setParameter("cpf", cpf)
                          .getSingleResult();
            } catch (javax.persistence.NoResultException e) {
                usuario = null;
            }

            if (usuario != null) {
                em.remove(usuario); 
                em.getTransaction().commit();
            } else {
                throw new Exception("Nenhum usuário encontrado com o CPF informado: " + cpf);
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

}