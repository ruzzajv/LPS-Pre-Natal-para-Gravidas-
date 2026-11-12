package entidades;

import javax.persistence.Entity;

@Entity
public class Credito extends Pagamento {
    
    private int parcelas;
    private String bandeira; // Visa, Mastercard, etc.

    public Credito() {
        super();
    }

    public int getParcelas() { return parcelas; }
    public void setParcelas(int parcelas) { this.parcelas = parcelas; }

    public String getBandeira() { return bandeira; }
    public void setBandeira(String bandeira) { this.bandeira = bandeira; }
}