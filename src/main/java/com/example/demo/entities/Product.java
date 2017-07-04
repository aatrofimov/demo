package com.example.demo.entities;

import javax.persistence.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 22:57<br>
 * todo javadoc
 */
@Entity
@Table(name = "PRODUCT", schema = "TESTWORK", catalog = "PUBLIC")
public class Product {
    private int productId;
    private String name;
    private int unitId;
    private int price;
    private Collection<DealingsHistory> dealingsHistoriesByProductId;
    private Collection<MatProd> matProdsByProductId;
    private Unit unitByUnitId;

    @Id
    @SequenceGenerator(name = "entitySeq", sequenceName="TESTWORK.ENTITY_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entitySeq")
    @Column(name = "PRODUCT_ID", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (unitId != product.unitId) return false;
        if (price != product.price) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + unitId;
        result = 31 * result + price;
        return result;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<DealingsHistory> getDealingsHistoriesByProductId() {
        return dealingsHistoriesByProductId;
    }

    public void setDealingsHistoriesByProductId(Collection<DealingsHistory> dealingsHistoriesByProductId) {
        this.dealingsHistoriesByProductId = dealingsHistoriesByProductId;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<MatProd> getMatProdsByProductId() {
        return matProdsByProductId;
    }

    public void setMatProdsByProductId(Collection<MatProd> matProdsByProductId) {
        this.matProdsByProductId = matProdsByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "UNIT_ID", referencedColumnName = "UNIT_ID", nullable = false)
    public Unit getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(Unit unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }
}
