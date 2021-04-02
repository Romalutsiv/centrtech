package com.myproject.centrtech.repo;

import com.myproject.centrtech.model.ShopGoodsAndService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ShopAndServiceRepo extends JpaRepository<ShopGoodsAndService, Long> {
}
