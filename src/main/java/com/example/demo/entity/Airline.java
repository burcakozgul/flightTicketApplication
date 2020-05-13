package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="telephone_number")
    private String telephoneNumber;

    @Column(name="number_of_aircraft")
    private int numberofAircraft;

    public void setId(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getNumberofAircraft() {
        return numberofAircraft;
    }

    public void setNumberofAircraft(int numberofAircraft) {
        this.numberofAircraft = numberofAircraft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
