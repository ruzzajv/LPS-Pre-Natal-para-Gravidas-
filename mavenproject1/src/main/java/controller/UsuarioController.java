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
        this.dao = new UsuarioDAO(); 
    }

    public void salvarUsuario(String nome, String cpf, String login, String senha, String email, String tipoPerfil) throws Exception {

        Usuario novoUsuario = null;

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

        novoUsuario.setNome(nome);
        novoUsuario.setLogin(login);
        novoUsuario.setSenha(senha);
        novoUsuario.setEmail(email);

        dao.salvar(novoUsuario);
    }

    public Usuario buscarPorCpf(String cpf) throws Exception {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new Exception("Informe um CPF válido para a busca.");
        }

        Usuario usuario = dao.buscarObjetoPorCpf(cpf.trim());
        if (usuario == null) {
            throw new Exception("Nenhum usuário encontrado com este CPF.");
        }
        return usuario;
    }

   public void atualizar(Long id, String nome, String cpf, String idade, String login, String senha, String email, String contato, String dataNasc) throws Exception {
    if (id == null) {
        throw new Exception("ID do usuário inválido para atualização.");
    }

   
    Usuario usuario = dao.buscarObjetoPorCpf(cpf); 
    if (usuario != null) {
        usuario.setNome(nome);
        usuario.setIdade(idade);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setContato(contato);
        usuario.setDataNasc(dataNasc);
       
        // usuario.setCpf(cpf);

        dao.editar(usuario);
    } else {
        throw new Exception("Usuário não encontrado para atualizar.");
    }
}

    public void excluirPorCpf(String cpf) throws Exception {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new Exception("O CPF não pode estar vazio para a exclusão.");
        }
        dao.excluirPorCpf(cpf.trim());
    }
}
