package com.myproject.centrtech.model;

import java.util.Set;

import com.myproject.enums.Defects;

public class Device {

    private Long id;                    
    private String type;                //тип вибору 
    private String name;                //марка
    private String model;               //модель
    private String serialNumber;        //серійний номер
    private String password;            //пароль ОС/BIOS
    private Set<Defects> defects;       //дефекти
    private String text;                //замовлена несправність

    public Device(){};

    public Device(String type, String name, String model, String serialNumber, String text){
        this.type = type;
        this.name = name;
        this.model = model;
        this.serialNumber = serialNumber;
        this.text = text;

    };
    
}
