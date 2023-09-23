package com.an.services;

import com.an.entities.Account;
import com.an.repositories.AccountRepository;

import java.util.List;

public class AccountService {
    private static final AccountRepository accountRepository = new AccountRepository();

    public List<Account> getAll(){
        return  accountRepository.getAll();
    }
    public boolean addAcc(Account account) {
        return accountRepository.addAcc(account);
    }
    public Account findAccByID(String id) {
        return accountRepository.findAccByID(id);
    }
    public Account updateAcc(Account updateAccount) {
        return accountRepository.updateAcc(updateAccount);
    }
    public Boolean deleteAccById(String accountId) {
        return accountRepository.deleteAccById(accountId);
    }
    public Account checkLogin(String userName, String password){
        return accountRepository.checkLogin(userName,password);
    }

}
