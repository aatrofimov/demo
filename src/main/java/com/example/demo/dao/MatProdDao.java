package com.example.demo.dao;

import com.example.demo.entities.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 04.07.2017<br>
 * Time: 1:42<br>
 * Dao для таблицы необходимых материалов продукции
 */
@Repository("matProdDao")
@Transactional(propagation = Propagation.MANDATORY)
public class MatProdDao extends AbstractDao<MatProd> {
    public MatProdDao() {
        super(MatProd.class);
    }

    /**
     * Получение записи
     * @param materialId id материала
     * @param productId id продукции
     */
    public MatProd getMatProd(int materialId, int productId) {
        return find("materialId", materialId, "productId", productId).get(0);
    }

    /**
     * Количество материала на единицу продукции
     * @param materialId id материала
     * @param productId id продукции
     */
    public double getMatProdValue(int materialId, int productId) {
        return getMatProd(materialId, productId).getValue();
    }
}
