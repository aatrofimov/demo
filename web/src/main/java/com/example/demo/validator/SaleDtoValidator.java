package com.example.demo.validator;

import com.example.demo.dao.ProductDao;
import com.example.demo.dto.SaleDto;
import com.example.demo.entities.Product;
import com.example.demo.entities.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 04.07.2017<br>
 * Time: 19:04<br>
 * Валидатор для SaleDto
 */
@Component
public class SaleDtoValidator implements Validator {

    private ProductDao productDao;

    @Autowired
    public SaleDtoValidator(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SaleDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SaleDto dto = (SaleDto)o;
        double value = dto.getValue();
        if (value <= 0) {
            errors.reject("Количество материала должно быть больше нуля");
        }
        Product product = productDao.find(dto.getProductId());
        if (product == null) {
            errors.reject("Продукция с таким id не существует");
        } else {
            Unit unit = product.getUnitByUnitId();
            if (!unit.isDivisibility() && (value - (int)value) != 0) {
                errors.reject("Дробные значения количества для данного типа продукции недопустимы");
            }
        }
    }
}
