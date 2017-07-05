package com.example.demo.dto;

import com.example.demo.entities.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 06.07.2017<br>
 * Time: 1:38<br>
 * Dto для информации по необходимым материалам для продукции
 */
public class MatProdDto {
    /**
     * pk
     */
    private int matProdId;
    /**
     * id материала
     */
    private int materialId;
    /**
     * id продукта
     */
    private int productId;
    /**
     * количество материала для получения единицы продукции
     */
    private double value;

    public MatProdDto(MatProd matProd) {
        this.matProdId = matProd.getMatProdId();
        this.materialId = matProd.getMaterialId();
        this.productId = matProd.getProductId();
        this.value = matProd.getValue();
    }

    public MatProdDto() {/* */}

    public int getMatProdId() {
        return matProdId;
    }

    public void setMatProdId(int matProdId) {
        this.matProdId = matProdId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
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
