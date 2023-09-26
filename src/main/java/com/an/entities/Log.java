package com.an.entities;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @Column(columnDefinition = "BIGINT(20)")
    private long iD;
    @Column(columnDefinition = "VARCHAR(50)")
    private String accountID;
    @Column(columnDefinition = "DATETIME")
    private Date loginTime;
    @Column(columnDefinition = "DATETIME")
    private Date logoutTime;
    @Column(columnDefinition = "VARCHAR(250)")
    private String notes;

    public long getiD() {
        return iD;
    }

    public void setiD(long iD) {
        this.iD = iD;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Log(long iD, String accountID, Date loginTime, Date logoutTime, String notes) {
        this.iD = iD;
        this.accountID = accountID;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.notes = notes;
    }

    public Log(Account user01, Date date, String id, String fullname) {
    }

    public Log(String accountID, Date loginTime) {
        this.accountID = accountID;
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "iD=" + iD +
                ", accountID='" + accountID + '\'' +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", notes='" + notes + '\'' +
                '}';
    }
}
