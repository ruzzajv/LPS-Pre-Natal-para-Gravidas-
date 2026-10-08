package controller;

import entidades.Usuario;
import entidades.Gerente;
import entidades.Atendente;
import entidades.Medico;
import entidades.Gestante;
import views.LoginV2;
import views.FrGerente;
import views.FrAtendente;
import views.FrMedico;
import views.FrGestante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class LoginController {

    private static final String PU = "com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU";

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        return emf.createEntityManager();
    }

    public void verificarLogin(String login, String senha, LoginV2 telaLogin) {
        if (login.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(telaLogin, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("login", login);
            query.setParameter("senha", senha);

            Usuario usuarioAutenticado = query.getSingleResult();

            if (usuarioAutenticado != null) {
                JOptionPane.showMessageDialog(telaLogin, "Login efetuado com sucesso! Bem-vindo(a), " + usuarioAutenticado.getNome());
                
              
                telaLogin.dispose();

    
                if (usuarioAutenticado instanceof Gerente) {
                    new FrGerente().setVisible(true);
                } else if (usuarioAutenticado instanceof Atendente) {
                    new FrAtendente().setVisible(true);
                } else if (usuarioAutenticado instanceof Medico) {
                    new FrMedico().setVisible(true);
                } else if (usuarioAutenticado instanceof Gestante) {
                    new FrGestante().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Perfil de utilizador desconhecido!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(telaLogin, "Utilizador ou senha incorretos!", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
            telaLogin.limparCampos();
        } finally {
            em.close();
        }
    }
}

