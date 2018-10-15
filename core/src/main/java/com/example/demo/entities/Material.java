package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 22:57<br>
 * Материал
 */
@Entity
@Table(name = "MATERIAL", schema = "TESTWORK", catalog = "PUBLIC")
public class Material {
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
    private Collection<DealingsHistory> dealingsHistoriesByMaterialId;
    private Unit unitByUnitId;
    private Collection<MatProd> matProdsByMaterialId;
    private Collection<Resource> resourcesByMaterialId;

    @Id
    @SequenceGenerator(name = "entitySeq", sequenceName="TESTWORK.ENTITY_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entitySeq")
    @Column(name = "MATERIAL_ID", nullable = false)
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
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
    @Column(name = "UNIT_ID", nullable = false, insertable = false, updatable = false)
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "PRICE", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Material material = (Material) o;

        if (materialId != material.materialId) return false;
        if (unitId != material.unitId) return false;
        if (price != material.price) return false;
        if (name != null ? !name.equals(material.name) : material.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = materialId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + unitId;
        result = 31 * result + price;
        return result;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<DealingsHistory> getDealingsHistoriesByMaterialId() {
        return dealingsHistoriesByMaterialId;
    }

    public void setDealingsHistoriesByMaterialId(Collection<DealingsHistory> dealingsHistoriesByMaterialId) {
        this.dealingsHistoriesByMaterialId = dealingsHistoriesByMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "UNIT_ID", referencedColumnName = "UNIT_ID", nullable = false)
    public Unit getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(Unit unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<MatProd> getMatProdsByMaterialId() {
        return matProdsByMaterialId;
    }

    public void setMatProdsByMaterialId(Collection<MatProd> matProdsByMaterialId) {
        this.matProdsByMaterialId = matProdsByMaterialId;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<Resource> getResourcesByMaterialId() {
        return resourcesByMaterialId;
    }

    public void setResourcesByMaterialId(Collection<Resource> resourcesByMaterialId) {
        this.resourcesByMaterialId = resourcesByMaterialId;
    }
}
