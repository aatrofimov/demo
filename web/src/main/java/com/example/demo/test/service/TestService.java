package com.example.demo.test.service;

import com.example.demo.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 06.07.2017<br>
 * Time: 5:32<br>
 * Сервис для тестов
 */
@Service
public class TestService {

    private ApplicationContext applicationContext;

    private ExecutorService executorService;

    private boolean interrupted;

    @Autowired
    public TestService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void start(int count) {
        interrupted = false;
        executorService = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            executorService.submit(new Test(applicationContext));
        }
    }

    public void stop() {
        interrupted = true;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean isInterrupted() {
        return interrupted;
    }
}
