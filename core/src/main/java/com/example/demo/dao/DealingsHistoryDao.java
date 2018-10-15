package com.example.demo.dao;

import com.example.demo.entities.DealType;
import com.example.demo.entities.DealingsHistory;
import com.example.demo.entities.Material;
import com.example.demo.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:46<br>
 * Dao для истории сделок
 */
@Repository("dealingsHistoryDao")
@Transactional(propagation = Propagation.MANDATORY)
public class DealingsHistoryDao extends AbstractDao<DealingsHistory> {
    public DealingsHistoryDao() {
        super(DealingsHistory.class);
    }

    /**
     * Создание записи о сделке
     * @param dealType тип договора
     * @param material материал
     * @param product продукция
     * @param value количество
     * @param price стоимость
     * @param description комментарий
     * @param isSuccessfully завершилась ли успешно
     * @return DealingsHistory
     */
    public DealingsHistory createHistory(
            DealType dealType,
            Material material,
            Product product,
            double value,
            int price,
            String description,
            boolean isSuccessfully
    ) {
        DealingsHistory dealingsHistory = new DealingsHistory();
        dealingsHistory.setDate(new Timestamp(System.currentTimeMillis()));
        dealingsHistory.setDealTypeByTypeId(dealType);
        dealingsHistory.setMaterialByMaterialId(material);
        dealingsHistory.setProductByProductId(product);
        dealingsHistory.setValue(value);
        dealingsHistory.setPrice(price);
        dealingsHistory.setSuccessfully(isSuccessfully);
        dealingsHistory.setDescription(description);
        return dealingsHistory;
    }
}
