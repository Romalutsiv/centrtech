package com.myproject.centrtech.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String addres;
//    private User director;
//    private Set<User> users;
//    private Set<Order> orders;
//    private Set<Goods> goods;
//     @OneToMany(fetch = FetchType.EAGER, mappedBy = "office")
//    private Set<Invoice> invoices;


    
}
