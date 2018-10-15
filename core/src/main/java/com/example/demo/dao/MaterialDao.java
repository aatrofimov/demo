package com.example.demo.dao;

import com.example.demo.entities.Material;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 02.07.2017<br>
 * Time: 15:47<br>
 * Dao для материалов
 */
@Repository("materialDao")
@Transactional(propagation = Propagation.MANDATORY)
public class MaterialDao extends AbstractDao<Material> {
    public MaterialDao() {
        super(Material.class);
    }
}
