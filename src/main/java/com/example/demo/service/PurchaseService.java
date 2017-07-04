package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import static com.example.demo.Constants.PURCHASE_DEAL_TYPE;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 6:29<br>
 * todo javadoc
 */
@Service
public class PurchaseService {

    private AccountDao accountDao;

    private TransactionDao transactionDao;

    private DealingsHistoryDao dealingsHistoryDao;

    private ResourceDao resourceDao;

    @Autowired
    public PurchaseService(
            AccountDao accountDao,
            TransactionDao transactionDao,
            DealingsHistoryDao dealingsHistoryDao,
            ResourceDao resourceDao
    ) {
        this.accountDao = accountDao;
        this.transactionDao = transactionDao;
        this.dealingsHistoryDao = dealingsHistoryDao;
        this.resourceDao = resourceDao;
    }

    @Transactional(rollbackFor = Exception.class)
    public void sellMaterial(MaterialDto dto) throws Exception {
        boolean isSuccessfully = dto.getPrice() >= accountDao.moneyOnAccount();
        String description = "";
        if (!isSuccessfully) {
            description = "Недостаточно средств на счете";
        }
        int dealId = dealingsHistoryDao.createHistory(
                PURCHASE_DEAL_TYPE,
                dto.getMaterialId(),
                null,
                dto.getValue(),
                (int) (dto.getPrice() / dto.getValue()),
                description,
                isSuccessfully);
        if (isSuccessfully) {
            transactionDao.createTransaction(-dto.getPrice(), PURCHASE_DEAL_TYPE, dealId, "");
            resourceDao.addResource(dto.getMaterialId(), dto.getValue());
        }
    }
}

