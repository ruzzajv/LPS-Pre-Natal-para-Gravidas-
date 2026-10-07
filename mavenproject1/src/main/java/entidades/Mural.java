package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Mural implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostMural;

    @Column(columnDefinition = "TEXT")
    private String textoDica;

    @Temporal(TemporalType.DATE)
    private Date dataPublicacao;


    @ManyToOne
    @JoinColumn(name = "id_gestante")
    private Gestante gestante;

  
    @ManyToOne
    @JoinColumn(name = "id_comunidade")
    private Comunidade comunidade;

    public Mural() {
    }


    public void crudDicas() {}

 
    public Long getIdPostMural() {
        return idPostMural;
    }

    public void setIdPostMural(Long idPostMural) {
        this.idPostMural = idPostMural;
    }

    public String getTextoDica() {
        return textoDica;
    }

    public void setTextoDica(String textoDica) {
        this.textoDica = textoDica;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Gestante getGestante() {
        return gestante;
    }

    public void setGestante(Gestante gestante) {
        this.gestante = gestante;
    }

    public Comunidade getComunidade() {
        return comunidade;
    }

    public void setComunidade(Comunidade comunidade) {
        this.comunidade = comunidade;
    }
}