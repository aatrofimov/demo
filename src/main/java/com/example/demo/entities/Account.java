package com.example.demo.entities;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 22:57<br>
 * todo javadoc
 */
@Entity
@Table(name = "ACCOUNT", schema = "TESTWORK", catalog = "PUBLIC")
public class Account {
    private int accountId;
    private int amount;

    @Id
    @Column(name = "ACCOUNT_ID")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "AMOUNT")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountId != account.accountId) return false;
        if (amount != account.amount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + amount;
        return result;
    }
}
