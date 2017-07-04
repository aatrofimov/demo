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

    private DealTypeDao dealTypeDao;

    @Autowired
    public TransactionDao(AccountDao accountDao, DealTypeDao dealTypeDao) {
        super(Transaction.class);
        this.accountDao = accountDao;
        this.dealTypeDao = dealTypeDao;
    }

    /**
     * Создание новой транзакции
     * @param money сумма
     * @param dealTypeId тип договора
     * @param dealId id записи в истории сделок
     * @param description комментарий
     * @throws Exception
     */
    public void createTransaction(int money, Integer dealTypeId, Integer dealId, String description) throws Exception {
        boolean haveDealTypeId = dealTypeId != null && dealTypeId > 0;
        if (haveDealTypeId) {
            DealType dealType = dealTypeDao.getDealType(dealTypeId);
            if (dealType.isProfitable() && money < 0 && !dealType.isProfitable() && money > 0) {
                throw new Exception("Тип договора не соответствует сумме транзакции");
            }
        }
        Transaction transaction = new Transaction();
        transaction.setAmount(money);
        transaction.setDate(new Timestamp(System.currentTimeMillis()));
        transaction.setDescription(description);
        if (dealId != null && dealId > 0) {
            transaction.setDealId(dealId);
        }
        persist(transaction);
        accountDao.changeAmount(transaction);
    }

}
