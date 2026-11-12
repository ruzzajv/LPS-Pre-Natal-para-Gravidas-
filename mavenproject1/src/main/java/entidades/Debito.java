package entidades;

import javax.persistence.Entity;

@Entity
public class Debito extends Pagamento {
    
    private String bandeira;

    public Debito() {
        super();
    }

    public String getBandeira() { return bandeira; }
    public void setBandeira(String bandeira) { this.bandeira = bandeira; }
}