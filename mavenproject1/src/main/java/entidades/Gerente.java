package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Gerente extends Usuario implements Serializable {

    private String nivelAcesso;

    public Gerente() {
    }


    public void contratarMedico() {}
    public void contratarAtendente() {}
    public void gerarRelatorio() {}


    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}