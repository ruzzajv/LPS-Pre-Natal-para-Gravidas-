package controller;

import dao.DinheiroDAO;
import entidades.Dinheiro;
import java.util.Date;

public class DinheiroController {

    private DinheiroDAO dao;

    public DinheiroController() {
        this.dao = new DinheiroDAO();
    }

    public double registrarPagamentoDinheiro(String nomePaciente, double valorTotal, double valorRecebido) {
        if (valorRecebido < valorTotal) {
            throw new IllegalArgumentException("O valor recebido é menor que o valor total da conta.");
        }
        
        double troco = valorRecebido - valorTotal;
        
        Dinheiro dinheiro = new Dinheiro();
        dinheiro.setNomePaciente(nomePaciente);
        dinheiro.setValor(valorTotal);
        dinheiro.setFormaPagamento("DINHEIRO");
        dinheiro.setStatus("PAGO");
        dinheiro.setDataPagamento(new Date());
        
        dinheiro.setValorRecebido(valorRecebido);
        dinheiro.setTroco(troco);
        
        dao.salvar(dinheiro);
        
        return troco;
    }
}