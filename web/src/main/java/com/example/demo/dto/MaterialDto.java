package com.example.demo.dto;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 6:20<br>
 * Dto для покупки материалов
 */
public class MaterialDto {

    /**
     * id материала
     */
    private int materialId;

    /**
     * Количество
     */
    private double value;

    public MaterialDto(int materialId, double value) {
        this.materialId = materialId;
        this.value = value;
    }

    public MaterialDto() {/* */};

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
