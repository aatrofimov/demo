package com.example.demo.dto;

import java.util.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 06.07.2017<br>
 * Time: 1:43<br>
 * Dto с информацией о продукте
 */
public class ProductDto {
    /**
     * pk
     */
    private int productId;
    /**
     * Наименование продукции
     */
    private String name;
    /**
     * единица измерения
     */
    private int unitId;
    /**
     * цена
     */
    private int price;
    /**
     * Необходимые ресурсы
     */
    private List<MatProdDto> matProdDtos;

    public ProductDto(int productId, String name, int unitId, int price, List<MatProdDto> matProdDtos) {
        this.productId = productId;
        this.name = name;
        this.unitId = unitId;
        this.price = price;
        this.matProdDtos = matProdDtos;
    }

    public ProductDto() {/* */}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<MatProdDto> getMatProdDtos() {
        return matProdDtos;
    }

    public void setMatProdDtos(List<MatProdDto> matProdDtos) {
        this.matProdDtos = matProdDtos;
    }
}
