package com.example.demo.test.controller;

import com.example.demo.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 06.07.2017<br>
 * Time: 5:26<br>
 * Контроллер для управления стресс-тестом
 */
@Controller
@RequestMapping("/test")
public class TestController {

    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    /**
     * Запуск теста
     * @param count количество потоков
     */
    @GetMapping("/start/{count}")
    public void start(@PathVariable("count") @NotNull Integer count) {
        testService.start(count);
    }

    /**
     * Остановка теста
     */
    @GetMapping("/stop")
    public void start() {
        testService.stop();
    }

}
