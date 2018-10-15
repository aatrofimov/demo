package com.example.demo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 22:57<br>
 * История сделок
 */
@Entity
@Table(name = "DEALINGS_HISTORY", schema = "TESTWORK", catalog = "PUBLIC")
public class DealingsHistory {
    /**
     * pk
     */
    private int dealHistoryId;
    /**
     * Тип догвоора
     */
    private int typeId;
    /**
     * id материала
     */
    private Integer materialId;
    /**
     * id продукции
     */
    private Integer productId;
    /**
     * количество материала (продукции)
     */
    private double value;
    /**
     * Стоимость
     */
    private int price;
    /**
     * Состоялась ли сделка
     */
    private boolean isSuccessfully;
    /**
     * Дата сделки
     */
    private Timestamp date;
    /**
     * Комментарий
     */
    private String description;
    private DealType dealTypeByTypeId;
    private Material materialByMaterialId;
    private Product productByProductId;
    private Collection<Transaction> transactionsByDealHistoryId;

    @Id
    @SequenceGenerator(name = "entitySeq", sequenceName="TESTWORK.ENTITY_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entitySeq")
    @Column(name = "DEAL_HISTORY_ID", nullable = false)
    public int getDealHistoryId() {
        return dealHistoryId;
    }

    public void setDealHistoryId(int dealHistoryId) {
        this.dealHistoryId = dealHistoryId;
    }

    @Basic
    @Column(name = "TYPE_ID", nullable = false, insertable = false, updatable = false)
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "MATERIAL_ID", insertable = false, updatable = false)
    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    @Basic
    @Column(name = "PRODUCT_ID", insertable = false, updatable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
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

    @Basic
    @Column(name = "PRICE", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int unitPrice) {
        this.price = unitPrice;
    }

    @Basic
    @Column(name = "IS_SUCCESSFULLY", nullable = false)
    public boolean isSuccessfully() {
        return isSuccessfully;
    }

    public void setSuccessfully(boolean successfully) {
        isSuccessfully = successfully;
    }

    @Basic
    @Column(name = "DATE", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DealingsHistory that = (DealingsHistory) o;

        if (dealHistoryId != that.dealHistoryId) return false;
        if (typeId != that.typeId) return false;
        if (Double.compare(that.value, value) != 0) return false;
        if (price != that.price) return false;
        if (isSuccessfully != that.isSuccessfully) return false;
        if (materialId != null ? !materialId.equals(that.materialId) : that.materialId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dealHistoryId;
        result = 31 * result + typeId;
        result = 31 * result + (materialId != null ? materialId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + price;
        result = 31 * result + (isSuccessfully ? 1 : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "DEAL_TYPE_ID", nullable = false)
    public DealType getDealTypeByTypeId() {
        return dealTypeByTypeId;
    }

    public void setDealTypeByTypeId(DealType dealTypeByTypeId) {
        this.dealTypeByTypeId = dealTypeByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "MATERIAL_ID", referencedColumnName = "MATERIAL_ID")
    public Material getMaterialByMaterialId() {
        return materialByMaterialId;
    }

    public void setMaterialByMaterialId(Material materialByMaterialId) {
        this.materialByMaterialId = materialByMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @OneToMany(mappedBy = "dealingsHistoryByDealId")
    public Collection<Transaction> getTransactionsByDealHistoryId() {
        return transactionsByDealHistoryId;
    }

    public void setTransactionsByDealHistoryId(Collection<Transaction> transactionsByDealHistoryId) {
        this.transactionsByDealHistoryId = transactionsByDealHistoryId;
    }
}
