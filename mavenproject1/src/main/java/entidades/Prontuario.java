package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Prontuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProntuario;

    @Column(length = 5)
    private String tipoSanguineo;

    private String alergias;

    public Prontuario() {
    }


    public void criarProntuario() {}
    public void atualizarProntuario() {}
    public void deletarProntuario() {}
    public void lerProntuario() {}

    public Long getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(Long idProntuario) {
        this.idProntuario = idProntuario;
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
}