package com.example.demo.entities;

import javax.persistence.*;
import java.sql.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 22:57<br>
 * todo javadoc
 */
@Entity
@Table(name = "TRANSACTION", schema = "TESTWORK", catalog = "PUBLIC")
public class Transaction {
    private int transactionId;
    private int amount;
    private Integer dealId;
    private Timestamp date;
    private String description;
    private DealingsHistory dealingsHistoryByDealId;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID", nullable = false)
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "AMOUNT", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "DEAL_ID", insertable = false, updatable = false)
    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    @Basic
    @Column(name = "DATE", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (transactionId != that.transactionId) return false;
        if (amount != that.amount) return false;
        if (dealId != null ? !dealId.equals(that.dealId) : that.dealId != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionId;
        result = 31 * result + amount;
        result = 31 * result + (dealId != null ? dealId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DEAL_ID", referencedColumnName = "DEAL_HISTORY_ID")
    public DealingsHistory getDealingsHistoryByDealId() {
        return dealingsHistoryByDealId;
    }

    public void setDealingsHistoryByDealId(DealingsHistory dealingsHistoryByDealId) {
        this.dealingsHistoryByDealId = dealingsHistoryByDealId;
    }
}
