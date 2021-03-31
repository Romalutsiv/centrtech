package com.myproject.centrtech.repo;

import com.myproject.centrtech.model.Invoice;

import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepo extends CrudRepository<Invoice, Long> {
    
}
