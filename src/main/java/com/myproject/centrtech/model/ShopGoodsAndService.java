package com.myproject.centrtech.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "shop_goods_service")
@ToString(of = {"id", "name", "price", "active", "goods", "count"})
@EqualsAndHashCode(of = {"id"})
@Setter
@Getter
@NoArgsConstructor
public class ShopGoodsAndService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Name.class)
    private Long id;
    @JsonView(Views.Name.class)
    private String name;
    @JsonView(Views.Name.class)
    private double price;
    private boolean active;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "shop_goods",
        joinColumns = @JoinColumn(name = "shop_goods_service_id"),
        inverseJoinColumns = @JoinColumn(name = "goods_id")
    )
    @JsonView(Views.Name.class)
    private Set<Goods> goods = new HashSet<>();
    @JsonView(Views.Name.class)
    private final int count = 1;

    @JsonView(Views.Name.class)
    private int storage_count = 0;

    public void addGoods(Goods good){
        goods.add(good);
        good.getShopGoodsAndServices().add(this);
    }
    
    
}
