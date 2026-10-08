package controller;

import dao.UsuarioDAO;
import entidades.Medico;

public class MedicoController {
    
    private UsuarioDAO repositorio;

    public MedicoController() {
        repositorio = new UsuarioDAO();
    }

  public void cadastrar(String nome, String cpf, String login, String senha, String email, String dataNasc, String contato, String idade, String crm, String especialidade) throws Exception {
        
        Medico novoMedico = new Medico();
        novoMedico.setNome(nome);
        novoMedico.setCpf(cpf);
        novoMedico.setLogin(login);
        novoMedico.setSenha(senha);
        novoMedico.setEmail(email);
        novoMedico.setDataNasc(dataNasc);
        novoMedico.setContato(contato);
        novoMedico.setIdade(idade);
        novoMedico.setCrm(crm);
        novoMedico.setEspecialidade(especialidade);
        
        repositorio.salvar(novoMedico);
    }
}