package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Gestante extends Usuario implements Serializable {

    /**
     * @return the previsaoDoParto
     */
    public String getPrevisaoDoParto() {
        return previsaoDoParto;
    }

    /**
     * @param previsaoDoParto the previsaoDoParto to set
     */
    public void setPrevisaoDoParto(String previsaoDoParto) {
        this.previsaoDoParto = previsaoDoParto;
    }

  
    private String diaDaDescoberta;

    private String semanasDeGravidez;
    
    private String previsaoDoParto;

   

    

    private String gravidezDeRisco;

    public Gestante() {
    }


    public void solicitarCadastro() {}
    public void acessarPagamentos() {}
    public void solicitarConsulta() {}

   
    public String getDiaDaDescoberta() {
        return diaDaDescoberta;
    }

    public void setDiaDaDescoberta(String diaDaDescoberta) {
        this.diaDaDescoberta = diaDaDescoberta;
    }

    public String getSemanasDeGravidez() {
        return semanasDeGravidez;
    }

    public void setSemanasDeGravidez(String semanasDeGravidez) {
        this.semanasDeGravidez = semanasDeGravidez;
    }


  

    public String getGravidezDeRisco() {
        return gravidezDeRisco;
    }

    public void setGravidezDeRisco(String gravidezDeRisco) {
        this.gravidezDeRisco = gravidezDeRisco;
    }
}