package com.example.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateAirportRequest {

    @NotEmpty
    private String name;
    private String address;
    private String telephoneNumber;
    private int numberofFlightDestinations;
    private int annualPassengerCapacity;

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
