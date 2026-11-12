package controller;

import dao.DebitoDAO;
import entidades.Debito;
import java.util.Date;

public class DebitoController {

    private DebitoDAO dao;

    public DebitoController() {
        this.dao = new DebitoDAO();
    }

    public void registrarPagamentoDebito(String nomePaciente, double valor, String bandeira) {
        Debito debito = new Debito();
        
        debito.setNomePaciente(nomePaciente);
        debito.setValor(valor);
        debito.setFormaPagamento("DEBITO");
        debito.setStatus("PAGO");
        debito.setDataPagamento(new Date());
        debito.setBandeira(bandeira);
        
        dao.salvar(debito);
    }
}