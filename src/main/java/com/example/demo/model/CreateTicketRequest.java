package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

public class CreateTicketRequest {

    private long flightCode;
    private String name;
    private String surname;
    private String tckn;
    private BigDecimal price;
    private Date createdDate;

    public long getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(long flightCode) {
        this.flightCode = flightCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
