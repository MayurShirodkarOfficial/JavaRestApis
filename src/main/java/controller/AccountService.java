package controller;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;

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
        public List<Account> getAllAccounts() {
        List<Account> list=entityManager.createQuery("SELECT a FROM Account a", Account.class).getResultList();
        return list;
    }

        public Account updateAccount(Account account) {
        entityManager.merge(account);
        return account;
    }
    public boolean deleteAccount(int id) {
        Account account = getAccountById(id);
        if (account != null) {
            entityManager.remove(account);
            return true;
        }
        return false;
    }

    }
