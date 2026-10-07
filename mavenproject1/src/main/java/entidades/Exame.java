package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExame;

    private String tipoExame;

    @Temporal(TemporalType.DATE)
    private Date dataSolicitacao;

    @Temporal(TemporalType.DATE)
    private Date dataRealizacao;

    @Column(columnDefinition = "TEXT")
    private String laudo;

    @ManyToOne
    @JoinColumn(name = "id_consulta")
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "id_gestante")
    private Gestante gestante;

    public Exame() {
    }


    public void registrar() {}
    public void inserirLaudo() {}
    public void concluirExame() {}


    public Long getIdExame() {
        return idExame;
    }

    public void setIdExame(Long idExame) {
        this.idExame = idExame;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Gestante getGestante() {
        return gestante;
    }

    public void setGestante(Gestante gestante) {
        this.gestante = gestante;
    }
}