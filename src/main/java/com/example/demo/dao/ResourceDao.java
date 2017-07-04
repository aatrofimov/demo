package com.example.demo.dao;

import com.example.demo.entities.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:49<br>
 * todo javadoc
 */
@Repository("resourceDao")
@Transactional(propagation = Propagation.MANDATORY)
public class ResourceDao extends AbstractDao<Resource> {
    public ResourceDao() {
        super(Resource.class);
    }

    public void addResource(int materialId, double value) {
        Resource resource = find("material_id", materialId).get(0);
        if (resource == null) {
            resource = new Resource();
            resource.setMaterialId(materialId);
            persist(resource);
        }
        resource.setValue(resource.getValue() + value);
    }
}
