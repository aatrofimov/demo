package com.example.demo.controller;

import com.example.demo.dto.DealDto;
import com.example.demo.dto.MaterialDto;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.PurchaseService;
import com.example.demo.validator.MaterialDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 6:14<br>
 * Контроллер для закупок материалов
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private PurchaseService service;

    private MaterialDtoValidator validator;

    @Autowired
    public PurchaseController(PurchaseService service, MaterialDtoValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @PostMapping(value = "")
    public DealDto sellMaterials(@RequestBody @Validated MaterialDto dto) throws ServiceException {
        try {
            return service.buyMaterial(dto);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
