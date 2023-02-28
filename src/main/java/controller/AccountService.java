package controller;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class AccountService {

    // using injection via @PersistenceUnit
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestUnit");
    // create a brand new EntityManager instance
    EntityManager entityManager = emf.createEntityManager();


    public Account getAccountById(int id){

        return entityManager.find(Account.class,id);
    }

    public Account createAccount(Account account){
        entityManager.persist(account);
        return account;
    }

}
