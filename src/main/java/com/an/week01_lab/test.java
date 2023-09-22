package com.an.week01_lab;

import com.an.db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Connection.getInstance().getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        EntityTransaction tr = em.getTransaction();

        tr.begin();
        try {
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }
}
