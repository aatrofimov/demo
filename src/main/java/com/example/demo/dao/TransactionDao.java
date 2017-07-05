package com.example.demo.dao;

import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:50<br>
 * Dao для транзакций
 */
@Repository("transactionDao")
@Transactional(propagation = Propagation.MANDATORY)
public class TransactionDao extends AbstractDao<Transaction> {

    private AccountDao accountDao;

    @Autowired
    public TransactionDao(AccountDao accountDao, DealTypeDao dealTypeDao) {
        super(Transaction.class);
        this.accountDao = accountDao;
    }

    /**
     * Создание новой транзакции
     * @param money сумма
     * @param dealType тип договора
     * @param deal запись в истории сделок
     * @param description комментарий
     * @throws Exception
     */
    public Transaction createTransaction(int money, DealType dealType, DealingsHistory deal, String description) throws Exception {
        if (dealType != null) {
            if (dealType.isProfitable() && money < 0 && !dealType.isProfitable() && money > 0) {
                throw new Exception("Тип договора не соответствует сумме транзакции");
            }
        }
        Transaction transaction = new Transaction();
        transaction.setAmount(money);
        transaction.setDate(new Timestamp(System.currentTimeMillis()));
        transaction.setDescription(description);
        transaction.setDealingsHistoryByDealId(deal);
        accountDao.changeAmount(transaction);
        return transaction;
    }

}
