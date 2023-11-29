package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.entities.Role;

import java.util.List;

public class test {
    public static void main(String[] args) {
        RoleRepository role = new RoleRepository();
        Role r = role.findRoleByAccountId("met");
        System.out.printf(r.toString());
    }
}
