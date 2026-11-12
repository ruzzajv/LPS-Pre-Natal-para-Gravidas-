package controller;

import dao.CreditoDAO;
import entidades.Credito;
import java.util.Date;

public class CreditoController {

    private CreditoDAO dao;

    public CreditoController() {
        this.dao = new CreditoDAO();
    }

    public void registrarPagamentoCredito(String nomePaciente, double valor, int parcelas, String bandeira) {
        Credito credito = new Credito();
        
        credito.setNomePaciente(nomePaciente);
        credito.setValor(valor);
        credito.setFormaPagamento("CREDITO");
        credito.setStatus("PAGO");
        credito.setDataPagamento(new Date());
        
        credito.setParcelas(parcelas);
        credito.setBandeira(bandeira);
        
        dao.salvar(credito);
    }
}