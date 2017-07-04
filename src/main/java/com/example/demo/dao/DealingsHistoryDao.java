package com.example.demo.dao;

import com.example.demo.entities.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:46<br>
 * todo javadoc
 */
@Repository("dealingsHistoryDao")
@Transactional(propagation = Propagation.MANDATORY)
public class DealingsHistoryDao extends AbstractDao<DealingsHistory> {
    public DealingsHistoryDao() {
        super(DealingsHistory.class);
    }

    public int createHistory(
            int typeId,
            Integer materialId,
            Integer productId,
            double value,
            int unitPrice,
            String description,
            boolean isSuccessfully
    ) {
        DealingsHistory dealingsHistory = new DealingsHistory();
        dealingsHistory.setDate(new Timestamp(System.currentTimeMillis()));
        dealingsHistory.setTypeId(typeId);
        dealingsHistory.setMaterialId(materialId);
        dealingsHistory.setProductId(productId);
        dealingsHistory.setValue(value);
        dealingsHistory.setUnitPrice(unitPrice);
        dealingsHistory.setSuccessfully(isSuccessfully);
        dealingsHistory.setDescription(description);
        persist(dealingsHistory);
        return dealingsHistory.getDealHistoryId();
    }
}
