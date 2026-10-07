package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Gestante extends Usuario implements Serializable {

    @Temporal(TemporalType.DATE)
    private Date diaDaDescoberta;

    private int semanasDeGravidez;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private Boolean cadAprovado;

    private Boolean gravidezDeRisco;

    public Gestante() {
    }


    public void solicitarCadastro() {}
    public void acessarPagamentos() {}
    public void solicitarConsulta() {}

   
    public Date getDiaDaDescoberta() {
        return diaDaDescoberta;
    }

    public void setDiaDaDescoberta(Date diaDaDescoberta) {
        this.diaDaDescoberta = diaDaDescoberta;
    }

    public int getSemanasDeGravidez() {
        return semanasDeGravidez;
    }

    public void setSemanasDeGravidez(int semanasDeGravidez) {
        this.semanasDeGravidez = semanasDeGravidez;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getCadAprovado() {
        return cadAprovado;
    }

    public void setCadAprovado(Boolean cadAprovado) {
        this.cadAprovado = cadAprovado;
    }

    public Boolean getGravidezDeRisco() {
        return gravidezDeRisco;
    }

    public void setGravidezDeRisco(Boolean gravidezDeRisco) {
        this.gravidezDeRisco = gravidezDeRisco;
    }
}