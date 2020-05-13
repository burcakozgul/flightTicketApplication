package com.example.demo.model;

import com.example.demo.entity.Airline;
import com.example.demo.entity.Airport;

public class GetAirportResponse {
    private Airport airport;
    private String resultDes;
    private int resultCode;

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public String getResultDes() {
        return resultDes;
    }

    public void setResultDes(String resultDes) {
        this.resultDes = resultDes;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}
