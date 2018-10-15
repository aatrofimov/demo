package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 03.07.2017<br>
 * Time: 22:57<br>
 * Типы договоров
 */
@Entity
@Table(name = "DEAL_TYPE", schema = "TESTWORK", catalog = "PUBLIC")
public class DealType {
    /**
     * pk
     */
    private int dealTypeId;
    /**
     * Название
     */
    private String name;
    /**
     * Описание
     */
    private String description;
    /**
     * Доходный/Расходный
     */
    private boolean profitable;
    private Collection<DealingsHistory> dealingsHistoriesByDealTypeId;

    @Id
    @SequenceGenerator(name = "entitySeq", sequenceName="TESTWORK.ENTITY_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entitySeq")
    @Column(name = "DEAL_TYPE_ID", nullable = false)
    public int getDealTypeId() {
        return dealTypeId;
    }

    public void setDealTypeId(int dealTypeId) {
        this.dealTypeId = dealTypeId;
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
    @Column(name = "PROFITABLE", nullable = false)
    public boolean isProfitable() {
        return profitable;
    }

    public void setProfitable(boolean profitable) {
        this.profitable = profitable;
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

        DealType dealType = (DealType) o;

        if (dealTypeId != dealType.dealTypeId) return false;
        if (name != null ? !name.equals(dealType.name) : dealType.name != null) return false;
        if (profitable != dealType.profitable) return false;
        if (description != null ? !description.equals(dealType.description) : dealType.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dealTypeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (profitable ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "dealTypeByTypeId")
    public Collection<DealingsHistory> getDealingsHistoriesByDealTypeId() {
        return dealingsHistoriesByDealTypeId;
    }

    public void setDealingsHistoriesByDealTypeId(Collection<DealingsHistory> dealingsHistoriesByDealTypeId) {
        this.dealingsHistoriesByDealTypeId = dealingsHistoriesByDealTypeId;
    }
}
