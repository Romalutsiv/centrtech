package com.myproject.centrtech.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/goods"})
public class GoodsController {

    @GetMapping
    public String incomeInvoide(){
        return "income_invoice";
    }

    @PostMapping("/new")
    public String newIncomeInvoice(
        // @RequestParam String date,
        // @RequestParam String provider,
        // @RequestParam String storage,
        // @RequestParam String delivery,
        @RequestParam Map<String, String> form 
    ){
        
        form.forEach((
            i, j) -> System.out.println(i +": " + j));
        return "redirect:/";
    }
    
}
