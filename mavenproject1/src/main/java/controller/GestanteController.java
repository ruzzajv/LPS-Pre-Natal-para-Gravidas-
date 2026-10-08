package controller;

import dao.UsuarioDAO;
import entidades.Gestante;

public class GestanteController {
    
    private UsuarioDAO repositorio;

    public GestanteController() {
        repositorio = new UsuarioDAO();
    }

    public void cadastrar(String nome, String cpf, String login, String senha, String email, String dataNasc, String contato, String idade, String diaDescoberta, String semanasGravidez, String previsaoParto, String gravidezRisco) throws Exception {
        
      
        
        Gestante novaGestante = new Gestante();
        novaGestante.setNome(nome);
        novaGestante.setCpf(cpf);
        novaGestante.setLogin(login);
        novaGestante.setSenha(senha);
        novaGestante.setEmail(email);
        novaGestante.setDataNasc(dataNasc);
        novaGestante.setContato(contato);
        novaGestante.setIdade(idade);
        novaGestante.setDiaDaDescoberta(diaDescoberta);
        novaGestante.setSemanasDeGravidez(semanasGravidez);
        novaGestante.setPrevisaoDoParto(previsaoParto);
        novaGestante.setGravidezDeRisco(gravidezRisco);

        repositorio.salvar(novaGestante);
    }
}