package com.an.services;

import com.an.entities.GrantAccess;
import com.an.repositories.GrantAccessRepository;

public class GrantAccessService {
    private static final GrantAccessRepository grantAccessRepository = new GrantAccessRepository();

    public GrantAccess getAllGrantAccessByAcc(String accountId) {
        return grantAccessRepository.getAllGrantAccessByAcc(accountId);
    }
}
