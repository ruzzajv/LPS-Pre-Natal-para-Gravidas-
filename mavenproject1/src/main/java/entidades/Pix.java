package entidades;

import javax.persistence.Entity;

@Entity
public class Pix extends Pagamento {
    
    private String codigoTransacao; // Chave do Pix ou ID do comprovante

    public Pix() {
        super();
    }

    public String getCodigoTransacao() { return codigoTransacao; }
    public void setCodigoTransacao(String codigoTransacao) { this.codigoTransacao = codigoTransacao; }
}