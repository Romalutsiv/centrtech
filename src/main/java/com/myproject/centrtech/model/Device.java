package com.myproject.centrtech.model;

import java.util.Set;

import javax.persistence.*;

import com.myproject.centrtech.enums.Defects;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "devices")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String type;                //тип вибору 
    @NonNull
    private String name;                //марка
    @NonNull
    private String model;               //модель
    @NonNull
    private String serialNumber;        //серійний номер
    @NonNull
    private String password;            //пароль ОС/BIOS

    @ElementCollection(targetClass = Defects.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "device_defects", joinColumns = @JoinColumn(name = "device_id"))
    @Enumerated(EnumType.STRING)
    private Set<Defects> defects;             //дефекти
    @NonNull
    private String text;                //замовлена несправність
}
