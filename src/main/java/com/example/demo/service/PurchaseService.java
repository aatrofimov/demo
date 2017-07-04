package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.dto.*;
import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import javax.persistence.*;

import static com.example.demo.Constants.PURCHASE_DEAL_TYPE;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 6:29<br>
 * Сервис для закупок
 */
@Service
public class PurchaseService {

    private AccountDao accountDao;

    private TransactionDao transactionDao;

    private DealingsHistoryDao dealingsHistoryDao;

    private ResourceDao resourceDao;

    private MaterialDao materialDao;

    @Autowired
    public PurchaseService(
            AccountDao accountDao,
            TransactionDao transactionDao,
            DealingsHistoryDao dealingsHistoryDao,
            ResourceDao resourceDao,
            MaterialDao materialDao
    ) {
        this.accountDao = accountDao;
        this.transactionDao = transactionDao;
        this.dealingsHistoryDao = dealingsHistoryDao;
        this.resourceDao = resourceDao;
        this.materialDao = materialDao;
    }

    /**
     * Покупка материалов
     * @see MaterialDto
     * @see DealDto
     * @param dto
     * @return DealDto
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public DealDto buyMaterial(MaterialDto dto) throws Exception {
        Material material = materialDao.find(dto.getMaterialId());
        if (material != null) {
            int totalPrice = (int) Math.floor(material.getPrice() * dto.getValue());
            boolean isSuccessfully = totalPrice >= accountDao.moneyOnAccount();
            String description = "";
            if (isSuccessfully) {
                description = "Куплен материал " + material.getName() +
                        " в объеме " + dto.getValue() + " " + material.getUnitByUnitId().getShortName() +
                        " на сумму " + totalPrice;
            } else {
                description = "Недостаточно средств на счете";
            }
            DealingsHistory dealHistory = dealingsHistoryDao.createHistory(
                    PURCHASE_DEAL_TYPE,
                    dto.getMaterialId(),
                    null,
                    dto.getValue(),
                    totalPrice,
                    description,
                    isSuccessfully);
            if (isSuccessfully) {
                transactionDao.createTransaction(-totalPrice, PURCHASE_DEAL_TYPE, dealHistory.getDealHistoryId(), "");
                resourceDao.addResource(dto.getMaterialId(), dto.getValue());
            }
            return new DealDto(dealHistory);
        } else {
            throw new EntityNotFoundException("Материал с таким id не существует");
        }
    }
}

