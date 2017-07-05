package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.dto.*;
import com.example.demo.entities.*;
import com.example.demo.helper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import static com.example.demo.Constants.SALE_DEAL_TYPE;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 04.07.2017<br>
 * Time: 18:23<br>
 * Сервис для продаж
 */
@Service
public class SellService {

    private ProductDao productDao;

    private ProductHelper helper;

    private AccountDao accountDao;

    private DealingsHistoryDao dealingsHistoryDao;

    private TransactionDao transactionDao;

    private ResourceDao resourceDao;

    private DealTypeDao dealTypeDao;

    @Autowired
    public SellService(
            ProductDao productDao,
            ProductHelper helper,
            AccountDao accountDao,
            DealingsHistoryDao dealingsHistoryDao,
            TransactionDao transactionDao,
            ResourceDao resourceDao,
            DealTypeDao dealTypeDao
    ) {
        this.productDao = productDao;
        this.helper = helper;
        this.accountDao = accountDao;
        this.dealingsHistoryDao = dealingsHistoryDao;
        this.transactionDao = transactionDao;
        this.resourceDao = resourceDao;
        this.dealTypeDao = dealTypeDao;
    }

    @Transactional(rollbackFor = Exception.class)
    public DealDto sellProduct(SaleDto saleDto) throws Exception {
        Product product = productDao.getProduct(saleDto.getProductId());
        int price = helper.getProductPrice(product, saleDto.getValue());
        boolean isEnoughMoney = price <= accountDao.moneyOnAccount();
        boolean isEnoughResources = resourceDao.checkResources(saleDto.getProductId(), saleDto.getValue());
        boolean isSuccessfully = isEnoughMoney && isEnoughResources;
        String description = "";
        if (isSuccessfully) {
            description = "Реализована продукция " + product.getName() +
                    " в объеме " + saleDto.getValue() + " " + product.getUnitByUnitId().getShortName() +
                    " на сумму " + price;
        } else {
            if (!isEnoughMoney) {
                description = "Недостаточно средств на счете;";
            }
            if (!isEnoughResources) {
                description += "Недостаточно ресурсов на складе;";
            }
        }
        DealType dealType = dealTypeDao.find(SALE_DEAL_TYPE);
        DealingsHistory dealHistory = dealingsHistoryDao.createHistory(
                dealType,
                null,
                product,
                saleDto.getValue(),
                price,
                description,
                isSuccessfully);
        if (isSuccessfully) {
            Transaction transaction = transactionDao.createTransaction(price, dealType, dealHistory, "");
            transactionDao.persist(transaction);
            resourceDao.removeResources(saleDto.getProductId(), saleDto.getValue());
        } else {
            dealingsHistoryDao.persist(dealHistory);
        }
        return new DealDto(dealHistory);
    }
}
