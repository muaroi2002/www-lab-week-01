package com.an.repositories;

import com.an.db.Connection;
import com.an.entities.GrantAccess;
import com.an.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    public EntityManager em;
    public RoleRepository() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }


    public List<Role> getRole(String id){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            String sql ="SELECT * FROM grant_access WHERE account_id = '" + id + "'";
            List<GrantAccess> dsGant = em.createNativeQuery(sql, GrantAccess.class).getResultList();
            List<Role> dsRole = new ArrayList<>();
            for (GrantAccess a:dsGant) {
                dsRole.add(a.getRole());
                System.out.println(a.getRole());
            }
            return dsRole;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public Role getOne(String id){
        return em.find(Role.class,id);
    }
    public List<Role> getAll(){
        return em.createQuery("select rl from role rl",Role.class).getResultList();
    }

    public List<Role> getRoleNoBelongAccount(String id){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            String sql = "SELECT * from role WHERE role_id not in (SELECT role_id FROM grant_access WHERE account_id = '"+id+"')";
            List<Role> ds = em.createNativeQuery(sql,Role.class).getResultList();
            transaction.commit();
            return ds;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }

        return null;
    }
    public List<Role> getRoleofAccount(String id){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            List<GrantAccess> dsGrant =em.createNativeQuery("SELECT * FROM grant_access WHERE account_id = '"+id+"'",GrantAccess.class).getResultList();
            List<Role> dsRole = new ArrayList<>();
            for (GrantAccess GrantAccess:dsGrant) {
                dsRole.add(GrantAccess.getRole());
            }
            transaction.commit();
            return  dsRole;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
    public boolean checkAdmin(String id){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Query a = em.createNativeQuery("SELECT * FROM grant_access WHERE account_id = '"+id+"' AND role_id ='role5'",GrantAccess.class);
            transaction.commit();
            if (a.getResultList().size() > 0){
                return true;
            }
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public GrantAccess getOneGrantAccess(String roleID, String accountId){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            GrantAccess GrantAccess = (GrantAccess) em.createNativeQuery("SELECT * FROM grant_access WHERE role_id ='"+roleID+"' and account_id ='"+accountId+"'",GrantAccess.class).getSingleResult();
            transaction.commit();
            return GrantAccess;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
    public boolean deleteGrantAccess(GrantAccess GrantAccess){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.remove(GrantAccess);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }public boolean insertRole(Role role){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(role);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public String getRoleLast(){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            String role=em.createQuery("select role_name from role rl order by rl.roleId desc",Role.class).getResultList().get(0).getId();
            transaction.commit();
            return role;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

}
