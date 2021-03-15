package com.myproject.centrtech.model;

import com.myproject.centrtech.enums.OrderType;
import com.myproject.centrtech.model.Device;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;              //даній клієнта
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;                  //майстр
    private LocalDate dateCreate;       //дата створення заказу
    private LocalDate datePaid;         //дата оплати заказу
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id")
    private Device device;              //дані пристрою
    private OrderType orderType;        //тип заказа(новий, виконаний..)
    private double price;               //ціна заказу

    public Order(){};

    public Order(Client client, Device device){
        this.client = client;
        this.device = device;
        this.dateCreate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDate getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(LocalDate datePaid) {
        this.datePaid = datePaid;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
