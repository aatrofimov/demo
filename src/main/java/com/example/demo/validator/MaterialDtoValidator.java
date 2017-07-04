package com.example.demo.validator;

import com.example.demo.dao.*;
import com.example.demo.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 6:32<br>
 * todo javadoc
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
        if (dto.getPrice() <= 0) {
            errors.reject("Стоимость должна быть больше нуля");
        }
        if (dto.getValue() <= 0) {
            errors.reject("Количество материала должно быть больше нуля");
        }
        if (dao.find(dto.getMaterialId()) == null) {
            errors.reject("Материал с таким типом не существует");
        }
    }
}
