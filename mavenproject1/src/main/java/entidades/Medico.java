package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Medico extends Usuario implements Serializable {

    @Column(nullable = false, unique = true)
    private String crm;

    private String especialidade;

    private boolean disponivel;

    public Medico() {
    }

  
    public void visualizarAgenda() {}
    public void registrarExame() {}
    public void visualizarExames() {}


    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}