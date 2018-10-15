package com.example.demo.controller;

import com.example.demo.dto.DealDto;
import com.example.demo.dto.SaleDto;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.SellService;
import com.example.demo.validator.SaleDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 04.07.2017<br>
 * Time: 18:23<br>
 * Контроллер для продаж продукции
 */
@RestController
@RequestMapping("/buy")
public class SellController {

    private SellService sellService;

    private SaleDtoValidator validator;

    @Autowired
    public SellController(SellService sellService, SaleDtoValidator validator) {
        this.sellService = sellService;
        this.validator = validator;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @PostMapping(value = "")
    public DealDto sell(@RequestBody @Validated SaleDto dto) throws ServiceException {
        try {
            return sellService.sellProduct(dto);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
