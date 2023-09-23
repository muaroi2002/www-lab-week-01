package com.an.repositories;

import com.an.db.Connection;
import com.an.entities.Account;
import com.an.entities.GrantAccess;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.sql.SQLException;
import java.util.List;

public class GrantAccessRepository {
    private EntityManager em;
    public GrantAccessRepository(){
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public GrantAccess getAllGrantAccessByAcc(String accountId) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "select * from account_grant where account_id =? ";
            GrantAccess grantAccess = (GrantAccess) em.createNativeQuery(sql,GrantAccess.class).setParameter(1,accountId).getSingleResult();
            tr.commit();
            return grantAccess;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }

}
