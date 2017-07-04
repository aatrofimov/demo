package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.exception.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 6:14<br>
 * todo javadoc
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private PurchaseService service;

    @Autowired
    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public void sellMaterials(@RequestBody @Validated MaterialDto dto) throws ServiceException {
        try {
            service.sellMaterial(dto);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
