package com.example.demo.controller;

import com.example.demo.dao.*;
import com.example.demo.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

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

    private DealingsHistoryDao dealingsHistoryDao;

    private ResourceDao resourceDao;

    @Autowired
    public InfoController(
            DealingsHistoryDao dealingsHistoryDao,
            ResourceDao resourceDao
    ) {
        this.dealingsHistoryDao = dealingsHistoryDao;
        this.resourceDao = resourceDao;
    }

    /**
     * Получение информации о сделках
     */
    @GetMapping("/gethistory")
    @ResponseBody
    public List<DealDto> getDealHistory() {
        return dealingsHistoryDao.selectAll().stream().map(DealDto::new).collect(Collectors.toList());
    }

    /**
     * Информация о ресурсах
     */
    @GetMapping("/resources")
    @ResponseBody
    public List<ResourceDto> getResources() {
        return resourceDao.selectAll().stream().map(ResourceDto::new).collect(Collectors.toList());
    }
}
