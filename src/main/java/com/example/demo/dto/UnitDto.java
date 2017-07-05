package com.example.demo.dto;

import com.example.demo.entities.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 21:29<br>
 * Dto для единиц измерения
 */
public class UnitDto {

    private int unitId;

    private String name;

    private String shortName;

    private boolean divisibility;

    public UnitDto(Unit unit) {
        this.unitId = unit.getUnitId();
        this.name = unit.getName();
        this.shortName = unit.getShortName();
        this.divisibility = unit.isDivisibility();
    }

    public UnitDto() {/* */}

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public boolean isDivisibility() {
        return divisibility;
    }

    public void setDivisibility(boolean divisibility) {
        this.divisibility = divisibility;
    }
}
