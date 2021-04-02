package com.myproject.centrtech.model;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    @JsonView(Views.Name.class)
    private int count;
    @NonNull
    private double priceNew;
    private double priceOld;
    private double priceDifference = 0;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "goodsType_id")
    @JsonView(Views.Name.class)
    private GoodsType type;

    @ManyToMany(mappedBy = "goods", fetch = FetchType.LAZY)
    private Set<ShopGoodsAndService> shopGoodsAndServices = new HashSet<>();
    
//    @ManyToMany(mappedBy = "goodsSet")
//    private Set<Invoice> invoices;
//    private Office storage;
    private String provider;
    
}
