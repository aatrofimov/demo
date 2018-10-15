package com.example.demo.dao;

import com.example.demo.entities.DealType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:47<br>
 * Dao для типов договоров
 */
@Repository("dealTypeDao")
@Transactional(propagation = Propagation.MANDATORY)
public class DealTypeDao extends AbstractDao<DealType> {
    public DealTypeDao() {
        super(DealType.class);
    }

    public DealType getDealType(int id) {
        DealType dealType = find(id);
        if (dealType == null) {
            throw new EntityNotFoundException("Вид договора с id " + id + " не найден");
        }
        return dealType;
    }
}
