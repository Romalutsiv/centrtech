package com.myproject.centrtech.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.myproject.centrtech.model.Goods;
import com.myproject.centrtech.model.GoodsType;
import com.myproject.centrtech.model.Invoice;
import com.myproject.centrtech.model.ShopGoodsAndService;
import com.myproject.centrtech.repo.GoodsRepo;
import com.myproject.centrtech.repo.GoodsTypeRepo;
import com.myproject.centrtech.repo.InvoiceRepo;

import com.myproject.centrtech.repo.ShopAndServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/goods"})
public class GoodsController {

    @Autowired
    GoodsRepo goodsRepo;
    @Autowired
    GoodsTypeRepo goodsTypeRepo;
    @Autowired
    InvoiceRepo invoiceRepo;
    @Autowired
    ShopAndServiceRepo shopRepo;

    @GetMapping("/new")
    public String incomeInvoide(Model model){
        Iterable<GoodsType> gtype = goodsTypeRepo.findAll();
        model.addAttribute("gtype", gtype);
        return "income_invoice";
    }

    @GetMapping("/new_type/g")
    public String newType(){
        return "new_type";
    }

    @PostMapping("/new_type/r")
    public String addType(@RequestParam String name){
        GoodsType g = new GoodsType(name);
        goodsTypeRepo.save(g);
        return "redirect:/";
    }

    @GetMapping
    public String all(Model model){
        Iterable<Goods> goods = goodsRepo.findAll();
        // goodsRepo.deleteById(186l);
        Goods g = goodsRepo.findByName("товар 5");
        if(g != null){
            model.addAttribute("good", g.getName());
        } else{
            model.addAttribute("good", "nema");
        }
        model.addAttribute("goods", goods);

        return "goods";
    }

    @PostMapping("/new")
    public String newIncomeInvoice(
        @RequestParam String date,
        @RequestParam String provider,
        @RequestParam String storage,
        @RequestParam String delivery,
        @RequestParam ArrayList<String> name,
        @RequestParam ArrayList<String> count,
        @RequestParam ArrayList<String> price,
        @RequestParam(name = "type") ArrayList<GoodsType> type,
        @RequestParam Map<String, String> form
    ){
        Set<Goods> goods = new HashSet<>();
        Goods good;
        for (int c = 0; c < name.size(); c++) {
            if(!(name.get(c).isEmpty())){
                if(goodsRepo.findByName(name.get(c)) != null){
                    good = goodsRepo.findByName(name.get(c));
                    good.setCount(good.getCount() + Integer.valueOf(count.get(c)));
                    good.setPriceOld(good.getPriceNew());
                    good.setPriceNew(Double.valueOf(price.get(c)));
                    good.setPriceDifference(good.getPriceOld() - good.getPriceNew());


                }else{
                        good = new Goods(name.get(c), Integer.valueOf(count.get(c)), Double.valueOf(price.get(c)));
                        good.setPriceOld(good.getPriceNew());
                        good.setPriceDifference(good.getPriceOld() - good.getPriceNew());
                        good.setType(type.get(c));

                }
            goodsRepo.save(good);

            goods.add(good);
            }
        }
        //     }
        // }
        // System.out.print("name: " + name);
        // System.out.print("count: " + count);

        String[] dateV = date.split("-");
        LocalDate data = LocalDate.of(Integer.valueOf(dateV[0]), Integer.valueOf(dateV[1]), Integer.valueOf(dateV[2]));
        System.out.print(data);
//        Invoice invoice = new Invoice(data, provider, Double.valueOf(delivery));
//        invoice.setGoodsSet(goods);
//        // invoice.setRecipient(recipient);
//        for (Goods god : goods) {
//            Set<Invoice> in = new HashSet<>();
//            if(god.getInvoices()!=null){
//                in = god.getInvoices();
//                in.add(invoice);
//                god.setInvoices(in);
//                goodsRepo.save(god);
//            }else {
//            in.add(invoice);
//            god.setInvoices(in);
//            goodsRepo.save(god);
//           }
//        }
//        invoiceRepo.save(invoice);


        return "redirect:/goods";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        Iterable<Goods> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);
        return "new_shop_good";
    }

    @PostMapping("/shop/new/q")
    public String addShop(@RequestParam(name = "good") Goods[] goods,
                          @RequestParam String price){
        ShopGoodsAndService shop = new ShopGoodsAndService();
        shop.setName(goods[0].getName());
        shop.setActive(true);
        shop.setPrice(Double.valueOf(price));
        for (Goods g: goods) {
            shop.addGoods(g);
        }
//        shop.setGoods(Collections.singleton(goods));
        shopRepo.save(shop);
//        goods.setShopGoodsAndServices(Collections.singleton(shop));
        for (Goods g: goods) {
            goodsRepo.save(g);
        }


        return "redirect:/goods";
    }
    
}
