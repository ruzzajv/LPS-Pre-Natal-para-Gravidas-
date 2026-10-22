package controller;

import dao.UsuarioDAO;
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

import javax.swing.JOptionPane;

public class LoginController {

    public void verificarLogin(String login, String senha, LoginV2 telaLogin) {
        if (login.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(telaLogin, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioAutenticado = dao.fazerLogin(login, senha);

        if (usuarioAutenticado != null) {
            
            
            SessaoController.setUsuarioLogado(usuarioAutenticado);
            
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
            
        } else {
            
            JOptionPane.showMessageDialog(telaLogin, "Utilizador ou senha incorretos!", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
            telaLogin.limparCampos();
        }
    }
}