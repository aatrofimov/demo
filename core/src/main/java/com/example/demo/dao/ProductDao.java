package com.example.demo.dao;

import com.example.demo.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:49<br>
 * Dao для продукции
 */
@Repository("productDao")
@Transactional(propagation = Propagation.MANDATORY)
public class ProductDao extends AbstractDao<Product> {
    public ProductDao() {
        super(Product.class);
    }

    public Product getProduct(int id) {
        Product product = find(id);
        if (product == null) {
            throw new EntityNotFoundException("Продукция с таким id не существует");
        }
        return product;
    }
}
