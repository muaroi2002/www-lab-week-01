package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Role;

public class RoleRepository {
    private EntityManager em;

    public RoleRepository() {
        em = Connection.getInstance().entityManagerFactory().createEntityManager();
    }
    public Role findRoleByAccountId(String accountId) {
        try {
            TypedQuery<Role> query = em.createQuery(
                    "SELECT r FROM GrantAccess gt " +
                            "INNER JOIN gt.role r " +
                            "INNER JOIN gt.account a " +
                            "WHERE a.id = :accountID", Role.class);
            query.setParameter("accountID", accountId);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
}
