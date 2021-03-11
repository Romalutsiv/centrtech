package com.myproject.centrtech.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;       //і"мя
    private String lastname;        //прізвище
    private String login;           //логін
    private String password;        //пароль
    private String addres;          //адрес
    private int phoneNumber;        //номер телефону


}
