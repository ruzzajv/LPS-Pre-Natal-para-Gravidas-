package entidades;

import javax.persistence.Entity;

@Entity
public class Dinheiro extends Pagamento {
    
    private double valorRecebido;
    private double troco;

    public Dinheiro() {
        super();
    }

    public double getValorRecebido() { return valorRecebido; }
    public void setValorRecebido(double valorRecebido) { this.valorRecebido = valorRecebido; }

    public double getTroco() { return troco; }
    public void setTroco(double troco) { this.troco = troco; }
}