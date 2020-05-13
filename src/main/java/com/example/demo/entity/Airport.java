package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="telephone_number")
    private String telephoneNumber;

    @Column(name="number_of_flight_destinations")
    private int numberofFlightDestinations;

    @Column(name="annual_passenger_capacity")
    private int annualPassengerCapacity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getNumberofFlightDestinations() {
        return numberofFlightDestinations;
    }

    public void setNumberofFlightDestinations(int numberofFlightDestinations) {
        this.numberofFlightDestinations = numberofFlightDestinations;
    }

    public int getAnnualPassengerCapacity() {
        return annualPassengerCapacity;
    }

    public void setAnnualPassengerCapacity(int annualPassengerCapacity) {
        this.annualPassengerCapacity = annualPassengerCapacity;
    }
}
