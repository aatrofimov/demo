package com.example.demo.dto;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 21:29<br>
 * todo javadoc
 */
public class UnitDto {

    private int unitId;

    private String name;

    private String shortName;

    private boolean divisibility;

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
