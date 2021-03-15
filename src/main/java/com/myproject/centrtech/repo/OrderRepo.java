package com.myproject.centrtech.repo;

import com.myproject.centrtech.enums.OrderType;
import com.myproject.centrtech.model.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> {
    Iterable<Order> findByOrderType(OrderType type);
    
}
