package com.example.demo.helper;

import com.example.demo.dao.*;
import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 05.07.2017<br>
 * Time: 2:30<br>
 * Helper для класса Product
 */
@Component
public class ProductHelper {

    private ProductDao productDao;

    @Autowired
    public ProductHelper(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * Получение стоимости продукции
     * @param id Id продукта
     * @param value объем продукции
     * @return цена продукции
     */
    public int getProductPrice(int id, double value) {
        return getProductPrice(productDao.getProduct(id), value);
    }

    /**
     * Получение стоимости продукции
     * @param product Entity продукции
     * @param value объем продукции
     * @return стоимость продукции
     */
    public int getProductPrice(Product product, double value) {
        double price = 0;
        for (MatProd matProd: product.getMatProdsByProductId()) {
            price = matProd.getMaterialByMaterialId().getPrice() * matProd.getValue();
        }
        return (int)Math.ceil(price * value);
    }
}
