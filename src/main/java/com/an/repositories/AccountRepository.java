package com.an.repositories;

import com.an.db.Connection;
import com.an.entities.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.checkerframework.checker.units.qual.A;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private EntityManager em;

    public AccountRepository() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public List<Account> getAll() {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "select * from account";
            List<Account> list = em.createNativeQuery(sql, Account.class).getResultList();
            tr.commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }

    public boolean addAcc(Account account) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(account);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public Account findAccByID(String id) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Account account = em.find(Account.class, id);
            tr.commit();
            return account;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return null;
    }

    public Account updateAcc(Account updateAccount) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Account acc = em.find(Account.class, updateAccount.getId());
            if (acc != null) {
                em.merge(updateAccount);
                tr.commit();
                return acc;
            } else {
                tr.rollback();
                return null;
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return null;
        }
    }

    public Boolean deleteAccById(String accountId) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Account acc = em.find(Account.class, accountId);
            if (acc != null) {
                em.remove(acc);
                tr.commit();
                return true;
            } else {
                tr.rollback();
                return null;
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public Account checkLogin(String email, String password){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "select * from account where email = ?1 and password = ?2";
            Account acc = (Account) em.createNativeQuery(sql, Account.class).setParameter(1, email).setParameter(2,password).getSingleResult();
            tr.commit();
            return acc;
        }catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return null;
    }
}
