package com.myproject.centrtech.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private LocalDate dataCreate;
    @ManyToMany
    @JoinTable(name="goods",
        joinColumns = @JoinColumn(name="invoice_id"),
        inverseJoinColumns = @JoinColumn(name="goods_id"))
    private Set<Goods> goodsSet;
    @NonNull
    private String sender;            //відправник   
    // @NonNull 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id")          
    private Office recipient;         //отримувач 
    @NonNull          
    private double delivery;            //доставка 

    
}
