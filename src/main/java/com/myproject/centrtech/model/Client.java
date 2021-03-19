package com.myproject.centrtech.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;            
    private String firstName;       //імя клієнта 
    private String lastName;        //прізвище клієнта
    private String mail;            //пошта клієнта
    private String addres;          //адрес клієнта
    private String phoneNumber;


    public Client(){};

    public Client(String firstName, String lastName, String mail, String addres){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.addres = addres;
    };
}
