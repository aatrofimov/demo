package com.example.demo.dao;

import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import javax.persistence.*;
import java.sql.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:50<br>
 * todo javadoc
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

    public void createTransaction(int money, Integer dealTypeId, Integer dealId, String description) throws Exception {
        boolean haveDealId = dealId != null && dealId > 0;
        boolean haveDealTypeId = dealTypeId != null && dealTypeId > 0;
        if (haveDealTypeId) {
            DealType dealType = dealTypeDao.find(dealTypeId);
            if (dealType == null) {
                throw new EntityNotFoundException("Вид договора с id " + dealTypeId + " не найден");
            }
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
