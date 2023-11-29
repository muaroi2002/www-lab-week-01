package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Account;

import java.util.List;
import java.util.Optional;

public class AccountRepository {
    private EntityManager em;

    public AccountRepository() {
        em = Connection.getInstance().entityManagerFactory().createEntityManager();
    }

    public Account login(String userName, String password) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "SELECT * FROM account WHERE account_id = ? AND PASSWORD = ? AND `status` = 1";
            Query query = em.createNativeQuery(sql, Account.class);
            query.setParameter(1,userName);
            query.setParameter(2,password);
            Account account = (Account) query.getSingleResult();
            tr.commit();
            return account;

        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return null;
    }
    public List<Account> getAll() {
        return em.createQuery("select c from Account c", Account.class)
                .getResultList();
    }
}
