package com.myproject.centrtech.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.myproject.centrtech.model.Client;
import com.myproject.centrtech.model.Device;
import com.myproject.enums.Defects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders() {
        return "orders";
    }
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(Model model){
        return "order";
    }
    @RequestMapping(value = "neworder", method = RequestMethod.GET)
    public String newOrder(Model model){
        model.addAttribute("defects", Defects.values());
        return "new_order";
    }
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String addOrder(
            @RequestParam String name,
            @RequestParam String lastname,
            @RequestParam String mail,
            @RequestParam String phonenumber,
            @RequestParam String addres,
            @RequestParam String type,
            @RequestParam String deviceName,
            @RequestParam String deviceModel,
            @RequestParam String serialNumber,
            @RequestParam String devicePass,
            @RequestParam Map<String, String> form,
            @RequestParam String text
     ){
        Set<String> defects = Arrays.stream(Defects.values())
            .map(Defects::name)
            .collect(Collectors.toSet());
        Device device = new Device(type, deviceName, deviceModel, serialNumber, text);
        Client client = new Client(name, lastname, mail, addres);
        client.setDevice(device);
        
        

        return "";
    }

}
