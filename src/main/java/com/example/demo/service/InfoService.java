package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.dto.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 05.07.2017<br>
 * Time: 19:45<br>
 * сервис для InfoController
 */
@Service
public class InfoService {

    private DealingsHistoryDao dealingsHistoryDao;

    private ResourceDao resourceDao;

    private TransactionDao transactionDao;

    private AccountDao accountDao;

    private UnitDao unitDao;

    private DealTypeDao dealTypeDao;

    public InfoService(
            DealingsHistoryDao dealingsHistoryDao,
            ResourceDao resourceDao,
            TransactionDao transactionDao,
            AccountDao accountDao,
            UnitDao unitDao,
            DealTypeDao dealTypeDao
    ) {
        this.dealingsHistoryDao = dealingsHistoryDao;
        this.resourceDao = resourceDao;
        this.transactionDao = transactionDao;
        this.accountDao = accountDao;
        this.unitDao = unitDao;
        this.dealTypeDao = dealTypeDao;
    }

    /**
     * Получение информации о сделках
     */
    public List<DealDto> getDealHistory() {
        return dealingsHistoryDao.selectAll().stream().map(DealDto::new).collect(Collectors.toList());
    }

    /**
     * Информация о ресурсах
     */
    public List<ResourceDto> getResources() {
        return resourceDao.selectAll().stream().map(ResourceDto::new).collect(Collectors.toList());
    }

    /**
     * Информация о транзакциях
     */
    public List<TransactionDto> getTransactions() {
        return transactionDao.selectAll().stream().map(TransactionDto::new).collect(Collectors.toList());
    }

    /**
     * Информация о счетах
     */
    public List<AccountDto> getAccounts() {
        return accountDao.selectAll().stream().map(AccountDto::new).collect(Collectors.toList());
    }

    /**
     * Получение списка типов доступных единиц измерения
     */
    public List<UnitDto> getUnits() {
        return unitDao.selectAll().stream().map(UnitDto::new).collect(Collectors.toList());
    }

    /**
     * Получение списка типов договоров
     */
    public List<DealTypeDto> getDealTypes() {
        return dealTypeDao.selectAll().stream().map(DealTypeDto::new).collect(Collectors.toList());
    }

}
