package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Atendente extends Usuario implements Serializable {

    private String turnoTrabalho;

    private int idAgenda;

    public Atendente() {
    }

    public void cadastrarGestante() {}
    public void gerenciarGestantes() {}
    public void gerenciarComunidade() {}
    public void emitirComprovante() {}
    public void agendarConsulta() {}
    public void gerarPagamento() {}
    public void gerenciarAgenda() {}

    public String getTurnoTrabalho() {
        return turnoTrabalho;
    }

    public void setTurnoTrabalho(String turnoTrabalho) {
        this.turnoTrabalho = turnoTrabalho;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }
}