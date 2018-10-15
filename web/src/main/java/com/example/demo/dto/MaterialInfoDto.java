package com.example.demo.dto;

import com.example.demo.entities.Material;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 06.07.2017<br>
 * Time: 1:19<br>
 * Dto с информацией о материале
 */
public class MaterialInfoDto {
    /**
     * id маткриала
     */
    private int materialId;
    /**
     * Наименование
     */
    private String name;
    /**
     * Единица измерения
     */
    private int unitId;
    /**
     * Стоимость
     */
    private int price;

    public MaterialInfoDto(Material material) {
        this.materialId = material.getMaterialId();
        this.name = material.getName();
        this.unitId = material.getUnitId();
        this.price = material.getPrice();
    }

    public MaterialInfoDto() {/* */}

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
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
}
