package com.myproject.centrtech.model;

import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Office {

    private Long id;
    private String name;
    private String addres;
    private User director;
    private Set<User> users;
    private Set<Order> orders;
    private Set<Goods> goods;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "office")
    private Set<Invoice> invoices;


    
}
