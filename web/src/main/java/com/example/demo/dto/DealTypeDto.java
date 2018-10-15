package com.example.demo.dto;

import com.example.demo.entities.DealType;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 05.07.2017<br>
 * Time: 19:37<br>
 * Dto для типов договоров
 */
public class DealTypeDto {
    /**
     * pk
     */
    private int dealTypeId;
    /**
     * Название
     */
    private String name;

    /**
     * Описание
     */

    private String description;
    /**
     * Доходный/Расходный
     */
    private boolean profitable;

    public DealTypeDto(DealType dealType) {
        this.dealTypeId = dealType.getDealTypeId();
        this.name = dealType.getName();
        this.description = dealType.getDescription();
        this.profitable = dealType.isProfitable();
    }

    public DealTypeDto() {/* */}

    public int getDealTypeId() {
        return dealTypeId;
    }

    public void setDealTypeId(int dealTypeId) {
        this.dealTypeId = dealTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProfitable() {
        return profitable;
    }

    public void setProfitable(boolean profitable) {
        this.profitable = profitable;
    }
}
