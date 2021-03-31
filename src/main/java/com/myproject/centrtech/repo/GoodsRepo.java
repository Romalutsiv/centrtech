package com.myproject.centrtech.repo;

import com.myproject.centrtech.model.Goods;

import org.springframework.data.repository.CrudRepository;

public interface GoodsRepo extends CrudRepository<Goods, Long> {
    Goods findByName(String name);
    
}
