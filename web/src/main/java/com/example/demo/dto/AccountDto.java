package com.example.demo.dto;

import com.example.demo.entities.Account;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 05.07.2017<br>
 * Time: 19:28<br>
 * Dto для банковских счетов
 */
public class AccountDto {

    /**
     * pk
     */
    private int accountId;
    /**
     * Сумма на счете
     */
    private int amount;

    public AccountDto(Account account) {
        this.accountId = account.getAccountId();
        this.amount = account.getAmount();
    }

    public AccountDto() {/* */}

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
