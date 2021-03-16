package com.myproject.centrtech.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.myproject.centrtech.enums.Defects;
import com.myproject.centrtech.enums.OrderType;
import com.myproject.centrtech.model.Client;
import com.myproject.centrtech.model.Device;
import com.myproject.centrtech.model.Order;
import com.myproject.centrtech.repo.ClientRepo;
import com.myproject.centrtech.repo.DeviceRepo;
import com.myproject.centrtech.repo.OrderRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/orders", "/"})
public class OrderController {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    DeviceRepo deviceRepo;

    @GetMapping()
    public String orders(@RequestParam(name="type", required = false) String type,Model model) {
        Iterable<Order> orders = orderRepo.findAll();
        if(type != null){
            orders = orderRepo.findByOrderType(OrderType.valueOf(type));
        }
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("neworder")
    public String newOrder(Model model){
        model.addAttribute("defects", Defects.values());
        return "new_order";
    }

    @PostMapping("orders")
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
            @RequestParam String text,
            Model model
     ){
        Device device = new Device(type, deviceName, deviceModel, serialNumber, devicePass, text);
        Set<Defects> def = new HashSet<>();
        Set<String> defects = Arrays.stream(Defects.values())
            .map(Defects::name)
            .collect(Collectors.toSet());
        
        for (String defect : form.keySet()) {
            if(defects.contains(defect)){
                def.add(Defects.valueOf(defect));
            }
        }
        device.setDefects(def);
        deviceRepo.save(device);
        Client client = new Client(name, lastname, mail, addres);
        clientRepo.save(client);
        Order order  = new Order(client, device);
        order.setOrderType(OrderType.NEW);
        orderRepo.save(order);
        
        return "redirect:/orders";
    }

    @GetMapping("delete/{order}")
    public String delete(@PathVariable Order order){
        orderRepo.delete(order);
        return "redirect:/orders";

    }
}
