package com.myproject.centrtech.model;

import java.util.Set;

import javax.persistence.*;

import com.myproject.centrtech.enums.Defects;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String type;                //тип вибору 
    private String name;                //марка
    private String model;               //модель
    private String serialNumber;        //серійний номер
    private String password;            //пароль ОС/BIOS

    @ElementCollection(targetClass = Defects.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "device_defects", joinColumns = @JoinColumn(name = "device_id"))
    @Enumerated(EnumType.STRING)
    private Set<Defects> defects;             //дефекти
    private String text;                //замовлена несправність


    public Device(){};

    public Device(String type, String name, String model, String serialNumber, String text){
        this.type = type;
        this.name = name;
        this.model = model;
        this.serialNumber = serialNumber;
        this.text = text;

    };

    public void setDefects(Set<Defects> def){
        this.defects = def;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public Order getOrder() {
    //     return order;
    // }

    // public void setOrder(Order order) {
    //     this.order = order;
    // }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Defects> getDefects() {
        return defects;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
