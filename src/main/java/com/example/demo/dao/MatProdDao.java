package com.example.demo.dao;

import com.example.demo.entities.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 04.07.2017<br>
 * Time: 1:42<br>
 * todo javadoc
 */
@Repository("matProdDao")
@Transactional(propagation = Propagation.MANDATORY)
public class MatProdDao extends AbstractDao<MatProd> {
    public MatProdDao() {
        super(MatProd.class);
    }
}
