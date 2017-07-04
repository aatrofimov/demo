package com.example.demo.entities;

import javax.persistence.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 22:57<br>
 * Единицы измерения
 */
@Entity
@Table(name = "UNIT", schema = "TESTWORK", catalog = "PUBLIC")
public class Unit {
    /**
     * pk
     */
    private int unitId;
    /**
     * Название
     */
    private String name;
    /**
     * Сокращенное название
     */
    private String shortName;
    /**
     * Делимость
     */
    private boolean divisibility;
    private Collection<Material> materialsByUnitId;
    private Collection<Product> productsByUnitId;

    @Id
    @SequenceGenerator(name = "entitySeq", sequenceName="TESTWORK.ENTITY_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entitySeq")
    @Column(name = "UNIT_ID", nullable = false)
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SHORT_NAME", nullable = false)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "DIVISIBILITY", nullable = false)
    public boolean isDivisibility() {
        return divisibility;
    }

    public void setDivisibility(boolean divisibility) {
        this.divisibility = divisibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (unitId != unit.unitId) return false;
        if (divisibility != unit.divisibility) return false;
        if (name != null ? !name.equals(unit.name) : unit.name != null) return false;
        if (shortName != null ? !shortName.equals(unit.shortName) : unit.shortName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (divisibility ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "unitByUnitId")
    public Collection<Material> getMaterialsByUnitId() {
        return materialsByUnitId;
    }

    public void setMaterialsByUnitId(Collection<Material> materialsByUnitId) {
        this.materialsByUnitId = materialsByUnitId;
    }

    @OneToMany(mappedBy = "unitByUnitId")
    public Collection<Product> getProductsByUnitId() {
        return productsByUnitId;
    }

    public void setProductsByUnitId(Collection<Product> productsByUnitId) {
        this.productsByUnitId = productsByUnitId;
    }
}
