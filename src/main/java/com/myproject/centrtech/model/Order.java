package com.myproject.centrtech.model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.myproject.enums.OrderType;


public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Client client;              //даній клієнта
    private User user;                  //майстр
    private Date dateCrea;              //дата створення заказу
    private Date datePaid;              //дата оплати заказу
    private Device device;              //дані пристрою
    private OrderType orderType;        //тип заказа(новий, виконаний..)



    
}
