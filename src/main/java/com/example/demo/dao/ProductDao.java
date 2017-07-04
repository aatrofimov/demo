package com.example.demo.dao;

import com.example.demo.entities.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:49<br>
 * todo javadoc
 */
@Repository("productDao")
@Transactional(propagation = Propagation.MANDATORY)
public class ProductDao extends AbstractDao<Product> {
    public ProductDao() {
        super(Product.class);
    }
}
