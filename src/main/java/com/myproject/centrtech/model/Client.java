package com.myproject.centrtech.model;

import java.util.Set;

public class Client {

    private Long id;            
    private String firstName;       //імя клієнта 
    private String lastName;        //прізвище клієнта
    private String mail;            //пошта клієнта
    private String addres;          //адрес клієнта
    private Set<Device> devices;     //пристроі клієнта

    public Client(){};

    public Client(String firstName, String lastName, String mail, String addres){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.addres = addres;
    };

    public void setDevice(Device device){
        this.devices.add(device);
    }


}
