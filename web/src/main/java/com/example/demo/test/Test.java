package com.example.demo.test;

import com.example.demo.dto.MaterialDto;
import com.example.demo.dto.SaleDto;
import com.example.demo.service.PurchaseService;
import com.example.demo.service.SellService;
import com.example.demo.test.service.TestService;
import org.springframework.context.ApplicationContext;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 06.07.2017<br>
 * Time: 5:43<br>
 * Тест
 */
public class Test extends Thread {

    private PurchaseService purchaseService;

    private SellService sellService;

    private TestService testService;

    public Test(ApplicationContext applicationContext) {
        purchaseService = applicationContext.getBean(PurchaseService.class);
        sellService = applicationContext.getBean(SellService.class);
        testService = applicationContext.getBean(TestService.class);
    }

    @Override
    public void run() {
        while (!testService.isInterrupted()) {
            try {
                if (rnd(1, 2) == 1) {
                    purchaseService.buyMaterial(getRandomMaterialDto());
                } else {
                    sellService.sellProduct(getRandomSaleDto());
                }
                Thread.sleep(10);
            } catch (Exception ignore) {/* */}
        }
    }

    private MaterialDto getRandomMaterialDto() {
        return new MaterialDto(rnd(10, 12), rnd(1, 100));
    }

    private SaleDto getRandomSaleDto() {
        return new SaleDto(rnd(30, 32), rnd(1, 20));
    }

    private static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
