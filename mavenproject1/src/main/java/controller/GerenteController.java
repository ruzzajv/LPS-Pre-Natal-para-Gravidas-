package controller;

import dao.UsuarioDAO;
import entidades.Gerente;

public class GerenteController {
    
    private UsuarioDAO repositorio;

    public GerenteController() {
        repositorio = new UsuarioDAO();
    }

    public void cadastrar(String nome, String cpf, String login, String senha, String email, String dataNasc, String contato, String idade, String nivelAcesso) throws Exception {
        
      
        Gerente novoGerente = new Gerente();
        novoGerente.setNome(nome);
        novoGerente.setCpf(cpf);
        novoGerente.setLogin(login);
        novoGerente.setSenha(senha);
        novoGerente.setEmail(email);
        novoGerente.setDataNasc(dataNasc);
        novoGerente.setContato(contato);
        novoGerente.setIdade(idade);
        novoGerente.setNivelAcesso(nivelAcesso);

        repositorio.salvar(novoGerente);
    }
}