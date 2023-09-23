package com.an.repositories;

import com.an.entities.Log;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LogRepository {
    private EntityManager em;
    private EntityTransaction tr;

    public LogRepository() {
        em = Persistence.createEntityManagerFactory("default").createEntityManager();
        tr = em.getTransaction();
    }

    public long insertLog(Log log) {
        try {
            tr.begin();
            em.persist(log);
            tr.commit();
            return log.getiD();
        } catch (Exception ex) {
            ex.printStackTrace();
            tr.rollback();
        }
        return -1;
    }

    public boolean updateLogoutTime(int logId) {
        try {
            tr.begin();
            Log log = getLogByID(logId);
            log.setLogoutTime(Timestamp.valueOf(LocalDateTime.now()));
            em.merge(log);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    public Log getLogByID(int id) {
        try {
            tr.begin();
            Log log = em.find(Log.class, id);
            tr.commit();
            return log;
        } catch (Exception e) {
            tr.rollback();
        }
        return null;
    }
}
