package entidades;

import java.io.Serializable;
import javax.persistence.*; // Importa todas as anotações do JPA de uma vez

/**
 *
 * @author emili
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // <-- ADICIONADO AQUI
public class Usuario implements Serializable {

    /**
     * @return the dataNasc
     */
    public String getDataNasc() {
        return dataNasc;
    }

    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id; 


    @Column(nullable = false)
    protected String login;

    @Column(nullable = false)
    protected String senha;

    @Column(nullable = false, unique = true)
    protected String email;

    protected String contato;
    
    private String cpf;

    @Column(nullable = false)
    protected String nome;

    private String dataNasc;
    
    protected String idade;

 

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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

  

    // --- MÉTODOS DO DIAGRAMA ---
    public void realizarLogin() {}
    public void fazerLogout() {}
    public void trocarSenha() {}
    public void recuperarSenha() {}
    public void acessarProntuario() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuario[ id=" + id + " ]";
    }
    
}