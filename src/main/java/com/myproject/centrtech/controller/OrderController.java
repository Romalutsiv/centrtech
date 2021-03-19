package com.myproject.centrtech.controller;

import com.lowagie.text.DocumentException;
import com.myproject.centrtech.enums.Defects;
import com.myproject.centrtech.enums.OrderType;
import com.myproject.centrtech.exporters.OrderExcelExporter;
import com.myproject.centrtech.exporters.OrderRecPDFExporter;
import com.myproject.centrtech.model.Client;
import com.myproject.centrtech.model.Device;
import com.myproject.centrtech.model.Order;
import com.myproject.centrtech.model.User;
import com.myproject.centrtech.repo.ClientRepo;
import com.myproject.centrtech.repo.DeviceRepo;
import com.myproject.centrtech.repo.OrderRepo;
import com.myproject.centrtech.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/orders", "/"})
public class OrderController {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    DeviceRepo deviceRepo;

    @Autowired
    private UserRepo userRepo;

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
        client.setPhoneNumber(phonenumber);
        clientRepo.save(client);
        Order order  = new Order(client, device);
        order.setOrderType(OrderType.NEW);
        order.setDateCreate(LocalDate.now());
        orderRepo.save(order);
        
        return "redirect:/orders";
    }

    @GetMapping("delete/{order}")
    public String delete(@PathVariable Order order){
        orderRepo.delete(order);
        return "redirect:/orders";

    }

    @GetMapping("/one/{order}")
    public String oneOrder(@PathVariable Order order, Model model){
        model.addAttribute("order", order);
        return "one_order";
    }

    @GetMapping("/receiving/{order}")
    public void receivingExcel(HttpServletResponse res, @PathVariable Order order) throws DocumentException, IOException{
        // res.setContentType("application/octet-stream");
        res.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachement; filename=заказ№"+order.getId()+"_від"+ order.getDateCreate()+"(receiving).xlsx";

        res.setHeader(headerKey, headerValue);
        File file = new File("C:/Users/user/Desktop/service.xlsx");
        // OrderExcelExporter rec = new OrderExcelExporter(order, file);
        OrderRecPDFExporter rec = new OrderRecPDFExporter(order);
        rec.export(res);
    }

    @GetMapping("/accept/{order}")
    public String acceptOrder(
                        @AuthenticationPrincipal User user,
                        @PathVariable Order order
                        ){
        order.setOrderType(OrderType.FOR_PERFORMANCE);
        order.setUser(user);
        user.getOrders().add(order);
        orderRepo.save(order);
        userRepo.save(user);

        return "redirect:/one/{order}";
    }

    @GetMapping("/to_pay/{order}")
    public String toPayOrder(
                        @PathVariable Order order
                        ){
        order.setOrderType(OrderType.TO_PAY);
        orderRepo.save(order);

        return "redirect:/one/{order}";
    }
}
