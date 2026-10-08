package controller;

import dao.UsuarioDAO;
import entidades.Atendente;

public class AtendenteController {
    
    private UsuarioDAO repositorio;

    public AtendenteController() {
        repositorio = new UsuarioDAO();
    }

    public void cadastrar(String nome, String cpf, String login, String senha, String email, String dataNasc, String contato, String idade, String turno) throws Exception {
        
     
        
     
        Atendente novoAtendente = new Atendente();
        novoAtendente.setNome(nome);
        novoAtendente.setCpf(cpf); 
        novoAtendente.setLogin(login);
        novoAtendente.setSenha(senha); 
        novoAtendente.setEmail(email);
        novoAtendente.setDataNasc(dataNasc);
        novoAtendente.setContato(contato);
        novoAtendente.setIdade(idade);
        novoAtendente.setTurnoTrabalho(turno); 
        
        repositorio.salvar(novoAtendente);
    }
}