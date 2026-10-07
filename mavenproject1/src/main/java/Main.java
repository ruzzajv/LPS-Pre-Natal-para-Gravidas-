package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("A iniciar a conexão com o JPA...");
        
        try {
            // Cole o nome exato aqui dentro:
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU");
            EntityManager em = emf.createEntityManager();
            
            System.out.println("SUCESSO! Conexão estabelecida e tabelas criadas no MySQL!");
            
            em.close();
            emf.close();
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco:");
            e.printStackTrace();
        }
    }
}