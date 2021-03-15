package com.myproject.centrtech.repo;

import com.myproject.centrtech.model.Client;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client, Long> {
    
}
