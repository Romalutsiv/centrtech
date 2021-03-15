package com.myproject.centrtech.repo;

import com.myproject.centrtech.model.Device;

import org.springframework.data.repository.CrudRepository;

public interface DeviceRepo extends CrudRepository<Device, Long>{
    
}
