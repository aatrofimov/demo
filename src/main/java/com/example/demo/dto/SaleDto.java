package com.example.demo.dto;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 04.07.2017<br>
 * Time: 19:03<br>
 * Dto для продажи продукции
 */
public class SaleDto {

    /**
     * id продукции
     */
    private int productId;

    /**
     * объем
     */
    private double value;

    public SaleDto(int productId, double value) {
        this.productId = productId;
        this.value = value;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
