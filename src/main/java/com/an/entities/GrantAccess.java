package com.an.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "grant_access")
public class GrantAccess {
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @Id
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(name = "is_grant", columnDefinition = "ENUM('1', '0', '-1')", nullable = false)
    @ColumnDefault("1")
    private Boolean grant;
    @Column(columnDefinition = "varchar(50)")
    @ColumnDefault("")
    private String note;

    public GrantAccess() {
    }

    public GrantAccess(Role role, Account account, Boolean grant, String note) {
        this.role = role;
        this.account = account;
        this.grant = grant;
        this.note = note;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getGrant() {
        return grant;
    }

    public void setGrant(Boolean grant) {
        this.grant = grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "role=" + role +
                ", account=" + account +
                ", grant=" + grant +
                ", note='" + note + '\'' +
                '}';
    }
}
