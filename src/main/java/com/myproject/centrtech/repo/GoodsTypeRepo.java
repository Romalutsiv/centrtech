package com.myproject.centrtech.repo;

import com.myproject.centrtech.model.GoodsType;

import org.springframework.data.repository.CrudRepository;

public interface GoodsTypeRepo extends CrudRepository<GoodsType, Long> {

    GoodsType findByName(String name);
    
}
