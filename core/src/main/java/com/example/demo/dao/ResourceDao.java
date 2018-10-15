package com.example.demo.dao;

import com.example.demo.entities.MatProd;
import com.example.demo.entities.Product;
import com.example.demo.entities.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:49<br>
 * Dao для ресурсов
 */
@Repository("resourceDao")
@Transactional(propagation = Propagation.MANDATORY)
public class ResourceDao extends AbstractDao<Resource> {

    private MatProdDao matProdDao;

    @Autowired
    public ResourceDao(MatProdDao matProdDao) {
        super(Resource.class);
        this.matProdDao = matProdDao;
    }

    /**
     * Добавление ресурса
     *
     * @param materialId id материала
     * @param value      количество
     */
    public void addResource(int materialId, double value) {
        Resource resource = find("materialId", materialId).get(0);
        if (resource == null) {
            resource = new Resource();
            resource.setMaterialId(materialId);
            persist(resource);
        }
        resource.setValue(resource.getValue() + value);
    }

    /**
     * Проверка доступности ресурсов
     *
     * @param product продукция
     * @param value   объем продукции
     * @return true, если ресурсов достаточно
     * @throws Exception
     */
    public boolean checkResources(Product product, double value) throws Exception {
        for (Resource resource : getResourcesByProduct(product)) {
            if (resource.getValue() < matProdDao.getMatProdValue(resource.getMaterialId(), product.getProductId()) * value) {
                return false;
            }
        }
        return true;
    }

    /**
     * Уменьшение ресурсов на складе
     *
     * @param product продукци
     * @param value   количество продукции
     * @throws Exception
     */
    public void removeResources(Product product, double value) throws Exception {
        for (Resource resource : getResourcesByProduct(product)) {
            double resVal = resource.getValue() - matProdDao.getMatProdValue(resource.getMaterialId(), product.getProductId()) * value;
            if (resVal < 0) {
                throw new Exception("Недостаточно ресурсов");
            }
            resource.setValue(resource.getValue() - matProdDao.getMatProdValue(resource.getMaterialId(), product.getProductId()));
        }
    }

    private Collection<Resource> getResourcesByProduct(Product product) {
        Collection<MatProd> matProds = product.getMatProdsByProductId();
        Set<Resource> resources = new HashSet<>();
        for (MatProd matProd : matProds) {
            resources.addAll(matProd.getMaterialByMaterialId().getResourcesByMaterialId());
        }
        return resources;
    }
}
