package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

public class AccountService {
    private static final AccountRepository accountRespository = new AccountRepository();
    public Account checkLogin(String username, String password) {
        return accountRespository.login(username, password);
    }
    public List<Account> getAll(){
        return accountRespository.getAll();
    }
}
