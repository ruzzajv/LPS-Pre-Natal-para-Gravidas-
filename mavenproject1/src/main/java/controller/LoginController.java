package controller;

import views.FrAtendente;
import views.FrGerente;
import views.FrAtendente;
import views.FrMedico;
import views.FrGestante;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginController {

    public void verificarLogin(String login, String senha, JFrame telaAtual) {
        
       
        if (login.equals("gerente") && senha.equals("123")) {
            abrirTela(new FrGerente(), telaAtual);
            
        } else if (login.equals("atendente") && senha.equals("123")) {
            abrirTela(new FrAtendente(), telaAtual);
            
        } else if (login.equals("medico") && senha.equals("123")) {
            abrirTela(new FrMedico(), telaAtual);
            
        } else if (login.equals("gestante") && senha.equals("123")) {
            abrirTela(new FrGestante(), telaAtual);
            
        } else {
            JOptionPane.showMessageDialog(telaAtual, "Login ou senha incorretos!", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirTela(JFrame novaTela, JFrame telaAtual) {
        novaTela.setLocationRelativeTo(null);
        novaTela.setVisible(true);
        if (telaAtual != null) {
            telaAtual.dispose();
        }
    }
}