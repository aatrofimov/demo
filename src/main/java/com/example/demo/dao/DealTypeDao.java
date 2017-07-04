package com.example.demo.dao;

import com.example.demo.entities.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:47<br>
 * todo javadoc
 */
@Repository("dealTypeDao")
@Transactional(propagation = Propagation.MANDATORY)
public class DealTypeDao extends AbstractDao<DealType> {
    public DealTypeDao() {
        super(DealType.class);
    }
}
