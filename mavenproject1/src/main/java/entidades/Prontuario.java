package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Prontuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProntuario;
    
    @Column(nullable = false, unique = true)
    private String cpfPaciente; 

    @Column(length = 5)
    private String tipoSanguineo;

    private String alergias;
    
    private String medicamentos;
    
    @Column(columnDefinition="TEXT") 
    private String condicoesPreExistentes;
    
    @Column(columnDefinition="TEXT")
    private String observacoes;
    
    @Column(columnDefinition="TEXT")
    private String observacoes1; 

    public Prontuario() {
    }

    public void criarProntuario() {}
    public void atualizarProntuario() {}
    public void deletarProntuario() {}
    public void lerProntuario() {}

    // --- GETTERS E SETTERS ---

    public Long getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(Long idProntuario) {
        this.idProntuario = idProntuario;
    }
    
    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getCondicoesPreExistentes() {
        return condicoesPreExistentes;
    }

    public void setCondicoesPreExistentes(String condicoesPreExistentes) {
        this.condicoesPreExistentes = condicoesPreExistentes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getObservacoes1() {
        return observacoes1;
    }

    public void setObservacoes1(String observacoes1) {
        this.observacoes1 = observacoes1;
    }
}