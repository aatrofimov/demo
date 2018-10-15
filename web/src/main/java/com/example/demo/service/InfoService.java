package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.dto.*;
import com.example.demo.helper.ProductHelper;
import com.example.demo.repository.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    private UnitRepository unitRepository;

    private DealTypeDao dealTypeDao;

    private MaterialDao materialDao;

    private ProductDao productDao;

    private ProductHelper productHelper;

    public InfoService(
            DealingsHistoryDao dealingsHistoryDao,
            ResourceDao resourceDao,
            TransactionDao transactionDao,
            AccountDao accountDao,
            UnitRepository unitRepository,
            DealTypeDao dealTypeDao,
            MaterialDao materialDao,
            ProductDao productDao,
            ProductHelper productHelper
    ) {
        this.dealingsHistoryDao = dealingsHistoryDao;
        this.resourceDao = resourceDao;
        this.transactionDao = transactionDao;
        this.accountDao = accountDao;
        this.unitRepository = unitRepository;
        this.dealTypeDao = dealTypeDao;
        this.materialDao = materialDao;
        this.productDao = productDao;
        this.productHelper = productHelper;
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
        return unitRepository.findAll().stream().map(UnitDto::new).collect(Collectors.toList());
    }

    /**
     * Получение списка типов договоров
     */
    public List<DealTypeDto> getDealTypes() {
        return dealTypeDao.selectAll().stream().map(DealTypeDto::new).collect(Collectors.toList());
    }

    /**
     * Получение списка материалов
     */
    public List<MaterialInfoDto> getMaterials() {
        return materialDao.selectAll().stream().map(MaterialInfoDto::new).collect(Collectors.toList());
    }

    /**
     * Получение списка продуктов
     */
    public List<ProductDto> getProducts() {
        return productDao.selectAll().stream().map(product -> new ProductDto(
                product.getProductId(),
                product.getName(),
                product.getUnitId(),
                productHelper.getProductPrice(product, 1.0),
                product.getMatProdsByProductId().stream().map(MatProdDto::new).collect(Collectors.toList())
        )).collect(Collectors.toList());
    }

}
