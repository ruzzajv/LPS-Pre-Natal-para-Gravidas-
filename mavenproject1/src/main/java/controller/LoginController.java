package controller;

import views.FrAtendente;
import views.FrGerente;
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
        // Informa à nova tela qual era o login (para o botão voltar funcionar depois)
        if (novaTela instanceof views.FrGerente) {
            ((views.FrGerente) novaTela).setTelaAnterior(telaAtual);
        } else if (novaTela instanceof views.FrAtendente) {
            ((views.FrAtendente) novaTela).setTelaAnterior(telaAtual);
        } else if (novaTela instanceof views.FrMedico) {
            ((views.FrMedico) novaTela).setTelaAnterior(telaAtual);
        } else if (novaTela instanceof views.FrGestante) {
            ((views.FrGestante) novaTela).setTelaAnterior(telaAtual);
        }

        novaTela.setLocationRelativeTo(null);
        novaTela.setVisible(true);
        
        // Fecha a tela de login atual completamente para ela sumir da tela
        if (telaAtual != null) {
            telaAtual.dispose();
        }
    }
}