package model;

import java.util.Date;

public class Gestante extends Usuario {

    private Date diaDaDescoberta;
    private int semanasDeGravidez;
    private Date dataNascimento;
    private boolean cadAprovado;
    private boolean gravidezDeRisco;

    public Gestante() {
        super();
        this.tipo = "Gestante";
    }

    public Gestante(int id, String login, String senha, String email, int contato,
            String nome, int idade, String tipo, Date diaDaDescoberta,
            int semanasDeGravidez, Date dataNascimento, boolean cadAprovado,
            boolean gravidezDeRisco) {
        super(id, login, senha, email, contato, nome, idade, tipo);
        this.diaDaDescoberta = diaDaDescoberta;
        this.semanasDeGravidez = semanasDeGravidez;
        this.dataNascimento = dataNascimento;
        this.cadAprovado = cadAprovado;
        this.gravidezDeRisco = gravidezDeRisco;
    }

    public void solicitarCadastro() {
    }

    public void AcessarPagamentos() {
    }

    public void solicitarConsulta() {
    }

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

    public boolean isCadAprovado() {
        return cadAprovado;
    }

    public void setCadAprovado(boolean cadAprovado) {
        this.cadAprovado = cadAprovado;
    }

    public boolean isGravidezDeRisco() {
        return gravidezDeRisco;
    }

    public void setGravidezDeRisco(boolean gravidezDeRisco) {
        this.gravidezDeRisco = gravidezDeRisco;
    }
}
