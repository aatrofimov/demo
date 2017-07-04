package com.example.demo.entities;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 22:57<br>
 * todo javadoc
 */
@Entity
@Table(name = "MAT_PROD", schema = "TESTWORK", catalog = "PUBLIC")
public class MatProd {
    private int matProdId;
    private int materialId;
    private int productId;
    private double value;
    private Material materialByMaterialId;
    private Product productByProductId;

    @Id
    @SequenceGenerator(name = "entitySeq", sequenceName="TESTWORK.ENTITY_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entitySeq")
    @Column(name = "MAT_PROD_ID", nullable = false)
    public int getMatProdId() {
        return matProdId;
    }

    public void setMatProdId(int matProdId) {
        this.matProdId = matProdId;
    }

    @Basic
    @Column(name = "MATERIAL_ID", nullable = false, insertable = false, updatable = false)
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Basic
    @Column(name = "PRODUCT_ID", nullable = false, insertable = false, updatable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "VALUE", nullable = false)
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatProd matProd = (MatProd) o;

        if (matProdId != matProd.matProdId) return false;
        if (materialId != matProd.materialId) return false;
        if (productId != matProd.productId) return false;
        if (Double.compare(matProd.value, value) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = matProdId;
        result = 31 * result + materialId;
        result = 31 * result + productId;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MATERIAL_ID", referencedColumnName = "MATERIAL_ID", nullable = false)
    public Material getMaterialByMaterialId() {
        return materialByMaterialId;
    }

    public void setMaterialByMaterialId(Material materialByMaterialId) {
        this.materialByMaterialId = materialByMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", nullable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
