package com.myproject.centrtech.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.myproject.centrtech.model.Goods;
import com.myproject.centrtech.model.ShopGoodsAndService;
import com.myproject.centrtech.model.Views;
import com.myproject.centrtech.repo.ShopAndServiceRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/chek")
public class ChekController {

    private final ShopAndServiceRepo shopRepo;
    private int counter = 4;

    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{ put("id", "1"); put("name", "SSD"); put("price", "150"); put("count", "1"); put("storage_count", "10"); put("but", "SSDb"); put("butn", "SSDn"); }});
        add(new HashMap<String, String>() {{ put("id", "2"); put("name", "БП GameMax GM-400B (новий)"); put("price", "15"); put("count", "1"); put("storage_count", "110"); put("but", "GameMaxb"); put("butn", "GameMaxn"); }});
        add(new HashMap<String, String>() {{ put("id", "3"); put("name", "заміна ОС"); put("price", "400"); put("count", "1"); put("but", "жосткий дискb"); put("butn", "жосткий дискn"); }});
        
    }};

    public ChekController(ShopAndServiceRepo shopRepo) {
        this.shopRepo = shopRepo;
    }

    @GetMapping
    @JsonView(Views.Name.class)
    public List<ShopGoodsAndService> list() {
        List<ShopGoodsAndService> sh = shopRepo.findAll();
        Set<Goods> gg = new HashSet<>();
        List<Goods> goods;
        int min = 0;
        for (ShopGoodsAndService s: sh) {
            gg = s.getGoods();
            if(gg.size() > 0){
                goods = new ArrayList<>(gg);
                min = goods.get(0).getCount();
                for (Goods g: goods) {

                    if(g.getCount() < min){
                        min = g.getCount();
                    }
                }
            }




            s.setStorage_count(min);
        }
        return shopRepo.findAll();
    }

    @GetMapping("{id}")
    public ShopGoodsAndService getOne(@PathVariable("id") ShopGoodsAndService shopGoodsAndService) {
        return shopGoodsAndService;
    }


    @PostMapping
    public ShopGoodsAndService create(@RequestBody ShopGoodsAndService shopGoodsAndService) {

        return shopRepo.save(shopGoodsAndService);
    }

    @PutMapping("{id}")
    public ShopGoodsAndService update(@PathVariable("id") ShopGoodsAndService spDb, @RequestBody ShopGoodsAndService shopGoodsAndService) {
        BeanUtils.copyProperties(shopGoodsAndService, spDb, "id");

        return shopRepo.save(spDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") ShopGoodsAndService sh) {
        shopRepo.delete(sh);
    }

}
