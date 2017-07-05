package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.exception.*;
import com.example.demo.service.*;
import com.example.demo.validator.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 6:14<br>
 * Контроллер для закупок материалов
 */
@Controller
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
    @ResponseBody
    public DealDto sellMaterials(@RequestBody @Validated MaterialDto dto) throws ServiceException {
        try {
            return service.buyMaterial(dto);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
