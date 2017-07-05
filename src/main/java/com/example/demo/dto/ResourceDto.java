package com.example.demo.dto;

import com.example.demo.entities.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 05.07.2017<br>
 * Time: 5:14<br>
 * Dto для ресурсов
 */
public class ResourceDto {

    /**
     * pk
     */
    private int resourceId;
    /**
     * id материала
     */
    private int materialId;
    /**
     * Количество
     */
    private double value;

    public ResourceDto(Resource resource) {
        this.resourceId = resource.getResourceId();
        this.materialId = resource.getMaterialId();
        this.value = resource.getValue();
    }

    public ResourceDto() {/* */}

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

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
