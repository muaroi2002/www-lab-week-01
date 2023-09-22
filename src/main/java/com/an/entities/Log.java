package com.an.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @Column(columnDefinition = "BIGINT(20)")
    private long iD;
    @Column(columnDefinition = "VARCHAR(50)")
    private String accountID;
    @Column(columnDefinition = "DATETIME")
    private Timestamp loginTime;
    @Column(columnDefinition = "DATETIME")
    private Timestamp logoutTime;
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

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public Timestamp getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Timestamp logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Log(long iD, String accountID, Timestamp loginTime, Timestamp logoutTime, String notes) {
        this.iD = iD;
        this.accountID = accountID;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.notes = notes;
    }

    public Log() {
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
