package com.example.demo.test.controller;

import com.example.demo.test.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.*;

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
