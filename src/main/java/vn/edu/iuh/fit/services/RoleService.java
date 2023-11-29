package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.repositories.RoleRepository;

public class RoleService {
    private static final RoleRepository roleRepo = new RoleRepository();
    public Role findRoleByAccountId(String accountId){
        return roleRepo.findRoleByAccountId(accountId);
    }
}
