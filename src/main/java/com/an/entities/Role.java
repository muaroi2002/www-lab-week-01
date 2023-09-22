package com.an.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id", columnDefinition = "varchar(50)")
    private String id;
    @Column(name = "role_name", columnDefinition = "varchar(50)",nullable = false)
    private String roleName;
    @Column(columnDefinition = "varchar(50)")
    private String description;
    @Column(columnDefinition = "tinyint(4)",nullable = false)


    private int status;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<GrantAccess> grantAccess;

    public Role() {
    }

    public Role(String id, String roleName, String description, int status, List<GrantAccess> grantAccess) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
        this.status = status;
        this.grantAccess = grantAccess;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<GrantAccess> getGrantAccess() {
        return grantAccess;
    }

    public void setGrantAccess(List<GrantAccess> grantAccess) {
        this.grantAccess = grantAccess;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", grantAccess=" + grantAccess +
                '}';
    }
}
