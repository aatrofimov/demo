package com.example.demo.dao;

import com.example.demo.entities.Account;
import com.example.demo.entities.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import static com.example.demo.Constants.ACCOUNT_ID;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:45<br>
 * Dao для банковского счета
 */
@Repository("accountDao")
@Transactional(propagation = Propagation.MANDATORY)
public class AccountDao extends AbstractDao<Account> {
    public AccountDao() {
        super(Account.class);
    }

    /**
     * @return сумма на счете
     */
    public long moneyOnAccount() {
        return getAccount().getAmount();
    }

    /**
     * Изменить состояние счета
     * @param transaction
     */
    public void changeAmount(Transaction transaction) {
        Account acc = getAccount();
        int amount = acc.getAmount() + transaction.getAmount();
        acc.setAmount(amount);
    }

    private Account getAccount() {
        Account acc = find(ACCOUNT_ID);
        if (acc == null) {
            throw new EntityNotFoundException("Счет не доступен");
        }
        return acc;
    }
}
