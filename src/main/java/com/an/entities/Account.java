package com.an.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "account_id",columnDefinition = "varchar(50)")
    private String id;
    @Column(name = "full_name",columnDefinition = "varchar(50)", nullable = false)
    private String fullname;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String password;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String email;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String phone;
    @Column(columnDefinition = "tinyint(4)", nullable = false)
    @ColumnDefault("1")
    private int status;
    @OneToMany
    private List<GrantAccess> grantAccesses;

    public Account() {
    }

    public Account(String id, String fullname, String password, String email, String phone, int status, List<GrantAccess> grantAccesses) {
        this.id = id;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.grantAccesses = grantAccesses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<GrantAccess> getGrantAccesses() {
        return grantAccesses;
    }

    public void setGrantAccesses(List<GrantAccess> grantAccesses) {
        this.grantAccesses = grantAccesses;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", grantAccesses=" + grantAccesses +
                '}';
    }
}
