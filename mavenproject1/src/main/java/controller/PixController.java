package controller;

import dao.PixDAO;
import entidades.Pix;
import java.util.Date;

public class PixController {

    private PixDAO dao;

    public PixController() {
        this.dao = new PixDAO();
    }

    public void registrarPagamentoPix(String nomePaciente, double valor, String codigoTransacao) {
        Pix pix = new Pix();
        
        pix.setNomePaciente(nomePaciente);
        pix.setValor(valor);
        pix.setFormaPagamento("PIX");
        pix.setStatus("PAGO");
        pix.setDataPagamento(new Date());
        pix.setCodigoTransacao(codigoTransacao);
        
        dao.salvar(pix);
    }
}