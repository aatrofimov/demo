package com.example.demo.dto;

import com.example.demo.entities.DealingsHistory;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 04.07.2017<br>
 * Time: 19:01<br>
 * Dto информации о сделке
 */
public class DealDto {

    /**
     * id сделки
     */
    private int dealId;

    /**
     * Тип договора
     */
    private int typeId;

    /**
     * id материала
     */
    private Integer materialId;

    /**
     * id продукции
     */
    private Integer productId;

    /**
     * Стоимость
     */
    private int price;

    /**
     * Дата заключения сделки
     */
    private Date date;

    /**
     * Комментарий
     */
    private String description;

    /**
     * Проведена до конца
     */
    private boolean isSuccessfully;

    public DealDto(DealingsHistory dealHistory) {
        this.dealId = dealHistory.getDealHistoryId();
        this.typeId = dealHistory.getTypeId();
        this.materialId = dealHistory.getMaterialId();
        this.productId = dealHistory.getProductId();
        this.price = dealHistory.getPrice();
        this.date = dealHistory.getDate();
        this.description = dealHistory.getDescription();
        this.isSuccessfully = dealHistory.isSuccessfully();
    }

    public DealDto() {/* */}

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSuccessfully() {
        return isSuccessfully;
    }

    public void setSuccessfully(boolean successfully) {
        isSuccessfully = successfully;
    }
}
