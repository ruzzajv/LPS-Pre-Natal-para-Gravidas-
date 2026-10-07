package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgenda;

    private String diasDeAtendimento;

    @ManyToOne
    @JoinColumn(name = "id_atendente")
    private Atendente atendente;

    public Agenda() {
    }

    public void criarAgenda() {}
    public void verificarDisponibilidade() {}
    public void atualizarAgenda() {}

    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Long idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getDiasDeAtendimento() {
        return diasDeAtendimento;
    }

    public void setDiasDeAtendimento(String diasDeAtendimento) {
        this.diasDeAtendimento = diasDeAtendimento;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }
}