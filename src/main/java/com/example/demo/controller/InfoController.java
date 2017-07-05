package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 05.07.2017<br>
 * Time: 5:04<br>
 * Контроллер для получения информации
 */
@RestController
@RequestMapping("/info")
public class InfoController {

    private InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    /**
     * Получение информации о сделках
     */
    @GetMapping("/history")
    @ResponseBody
    public List<DealDto> getDealHistory() {
        return infoService.getDealHistory();
    }

    /**
     * Информация о ресурсах
     */
    @GetMapping("/resources")
    @ResponseBody
    public List<ResourceDto> getResources() {
        return infoService.getResources();
    }

    /**
     * Информация о транзакциях
     */
    @GetMapping("/transactions")
    @ResponseBody
    public List<TransactionDto> getTransactions() {
        return infoService.getTransactions();
    }

    /**
     * Информация о счетах
     */
    @GetMapping("/accounts")
    @ResponseBody
    public List<AccountDto> getAccounts() {
        return infoService.getAccounts();
    }

    /**
     * Получение списка типов доступных единиц измерения
     */
    @GetMapping("/units")
    @ResponseBody
    public List<UnitDto> getUnits() {
        return infoService.getUnits();
    }

    @GetMapping("/dealtypes")
    @ResponseBody
    public List<DealTypeDto> getDealTypes() {
        return infoService.getDealTypes();
    }

    @GetMapping("/materials")
    @ResponseBody
    public List<MaterialInfoDto> getMaterials() {
        return infoService.getMaterials();
    }

    @GetMapping("/products")
    @ResponseBody
    public List<ProductDto> getProducts() {
        return infoService.getProducts();
    }
}
