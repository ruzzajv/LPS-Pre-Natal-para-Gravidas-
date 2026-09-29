package model;

public abstract class Usuario {

    protected int id;
    protected String login;
    protected String senha;
    protected String email;
    protected int contato;
    protected String nome;
    protected int idade;
    protected String tipo;

    public Usuario() {
    }

    public Usuario(int id, String login, String senha, String email, int contato, String nome, int idade, String tipo) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.contato = contato;
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
    }

    public boolean realizarLogin() {
        return false;
    }

    public void fazerLogout() {
    }

    public boolean trocarSenha(String novaSenha) {
        this.senha = novaSenha;
        return true;
    }

    public void recuperarSenha() {
    }

    public void AcessarProntuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContato() {
        return contato;
    }

    public void setContato(int contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
