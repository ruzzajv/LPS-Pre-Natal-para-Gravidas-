package controller;

import dao.UsuarioDAO;
import entidades.Usuario;
import entidades.Gerente;
import entidades.Atendente;
import entidades.Medico;
import entidades.Gestante;

public class UsuarioController {

    private UsuarioDAO dao;

    public UsuarioController() {
        this.dao = new UsuarioDAO(); // Instancia a conexão com o banco
    }

    public void salvarUsuario(String nome, String cpf, String login, String senha, String email, String tipoPerfil) throws Exception {
        
        Usuario novoUsuario = null;

        // Aplica a herança de acordo com os RadioButtons da tela
        switch (tipoPerfil.toUpperCase()) {
            case "GERENTE":
                novoUsuario = new Gerente();
                break;
            case "ATENDENTE":
                novoUsuario = new Atendente();
                break;
            case "MEDICO":
                novoUsuario = new Medico();
                break;
            case "GESTANTE":
                novoUsuario = new Gestante();
                break;
            default:
                throw new Exception("Tipo de perfil inválido ou não selecionado.");
        }

        // Preenche os dados comuns da entidade Usuario
        novoUsuario.setNome(nome);
        novoUsuario.setLogin(login);
        novoUsuario.setSenha(senha);
        novoUsuario.setEmail(email);

        // Chama o DAO para salvar no banco
        dao.salvar(novoUsuario);
    }
}