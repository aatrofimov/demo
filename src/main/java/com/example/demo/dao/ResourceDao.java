package com.example.demo.dao;

import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

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
     * @param materialId id материала
     * @param value количество
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
     * @param productId id продукции
     * @param value объем продукции
     * @return true, если ресурсов достаточно
     * @throws Exception
     */
    public boolean checkResources(int productId, double value) throws Exception {
        List<Resource> resources = find("product_id", productId);
        for (Resource resource: resources) {
            if (resource.getValue() < matProdDao.getMatProdValue(resource.getMaterialId(), productId) * value) {
                return false;
            }
        }
        return true;
    }

    /**
     * Уменьшение ресурсов на складе
     * @param productId id продукции
     * @param value количество продукции
     * @throws Exception
     */
    public void removeResources(int productId, double value) throws Exception {
        List<Resource> resources = find("product_id", productId);
        for (Resource resource: resources) {
            double resVal = resource.getValue() - matProdDao.getMatProdValue(resource.getMaterialId(), productId) * value;
            if (resVal < 0) {
                throw new Exception("Недостаточно ресурсов");
            }
            resource.setValue(resource.getValue() - matProdDao.getMatProdValue(resource.getMaterialId(), productId));
        }
    }
}
