package com.myproject.centrtech.model;

import com.myproject.centrtech.enums.OrderType;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @NonNull
    private Client client;              //даній клієнта
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;                  //майстр
    private LocalDate dateCreate;       //дата створення заказу
    private LocalDate datePaid;         //дата оплати заказу
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id")
    @NonNull
    private Device device;              //дані пристрою

//    @OneToOne
//    @JoinColumn(name = "chek_id")
//    private Chek chek;
    private OrderType orderType;        //тип заказа(новий, виконаний..)
    private double price;               //ціна заказу
}
