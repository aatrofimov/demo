package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<DealDto> getDealHistory() {
        return infoService.getDealHistory();
    }

    /**
     * Информация о ресурсах
     */
    @GetMapping("/resources")
    public List<ResourceDto> getResources() {
        return infoService.getResources();
    }

    /**
     * Информация о транзакциях
     */
    @GetMapping("/transactions")
    public List<TransactionDto> getTransactions() {
        return infoService.getTransactions();
    }

    /**
     * Информация о счетах
     */
    @GetMapping("/accounts")
    public List<AccountDto> getAccounts() {
        return infoService.getAccounts();
    }

    /**
     * Получение списка типов доступных единиц измерения
     */
    @GetMapping("/units")
    public List<UnitDto> getUnits() {
        return infoService.getUnits();
    }

    /**
     * типы договоров
     */
    @GetMapping("/dealtypes")
    public List<DealTypeDto> getDealTypes() {
        return infoService.getDealTypes();
    }

    /**
     * Список используемых материалов
     */
    @GetMapping("/materials")
    public List<MaterialInfoDto> getMaterials() {
        return infoService.getMaterials();
    }

    /**
     * Список доступных продуктов
     */
    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return infoService.getProducts();
    }
}
