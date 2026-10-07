package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Informacoes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInformacao;

    private String tituloAviso;

    @Column(columnDefinition = "TEXT")
    private String conteudoTecnico;

    @Temporal(TemporalType.DATE)
    private Date dataPublicacao;

   
    @ManyToOne
    @JoinColumn(name = "id_comunidade")
    private Comunidade comunidade;

    public Informacoes() {
    }


    public void crudInformacoes() {}

    
    public Long getIdInformacao() {
        return idInformacao;
    }

    public void setIdInformacao(Long idInformacao) {
        this.idInformacao = idInformacao;
    }

    public String getTituloAviso() {
        return tituloAviso;
    }

    public void setTituloAviso(String tituloAviso) {
        this.tituloAviso = tituloAviso;
    }

    public String getConteudoTecnico() {
        return conteudoTecnico;
    }

    public void setConteudoTecnico(String conteudoTecnico) {
        this.conteudoTecnico = conteudoTecnico;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Comunidade getComunidade() {
        return comunidade;
    }

    public void setComunidade(Comunidade comunidade) {
        this.comunidade = comunidade;
    }
}