package com.an.services;

import com.an.entities.Log;
import com.an.repositories.LogRepository;

public class LogService {
    private LogRepository repository;
    public long insertLog(Log log) {
        return repository.insertLog(log);
    }
    public boolean updateLogoutTime(int logId) {
        return repository.updateLogoutTime(logId);
    }
    public Log getLogByID(int id) {
        return repository.getLogByID(id);
    }
}
