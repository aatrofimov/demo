package com.example.demo.dto;

import com.example.demo.entities.Transaction;

import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 05.07.2017<br>
 * Time: 19:17<br>
 * Dto для транзакций
 */
public class TransactionDto {
    /**
     * pk
     */
    private int transactionId;
    /**
     * Сумма в транзакции
     */
    private int amount;
    /**
     * id сделки
     */
    private Integer dealId;
    /**
     * Дата совершения транзакции
     */
    private Timestamp date;
    /**
     * Комментарий
     */
    private String description;

    public TransactionDto(Transaction transaction) {
        this.transactionId = transaction.getTransactionId();
        this.amount = transaction.getAmount();
        this.dealId = transaction.getDealId();
        this.date = transaction.getDate();
        this.description = transaction.getDescription();
    }

    public TransactionDto() {/* */}

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
