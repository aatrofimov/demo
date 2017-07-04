package com.example.demo.validator;

import com.example.demo.dao.*;
import com.example.demo.dto.*;
import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 6:32<br>
 * Валидатор для MaterialDto
 */
@Component
public class MaterialDtoValidator implements Validator {

    private MaterialDao dao;

    @Autowired
    public MaterialDtoValidator(MaterialDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return MaterialDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MaterialDto dto = (MaterialDto)o;
        double value = dto.getValue();
        if (value <= 0) {
            errors.reject("Количество материала должно быть больше нуля");
        }

        Material material = dao.find(dto.getMaterialId());
        if (material == null) {
            errors.reject("Материал с таким id не существует");
        } else {
            Unit unit = material.getUnitByUnitId();
            if (!unit.isDivisibility() && (value - (int)value) != 0) {
                errors.reject("Дробные значения количества материала для данного типа материала недопустимы");
            }
        }
    }
}
