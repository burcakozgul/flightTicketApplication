package com.example.demo.controller;

import com.example.demo.model.CreateAirportRequest;
import com.example.demo.model.CreateAirportResponse;
import com.example.demo.model.GetAirportResponse;
import com.example.demo.repository.AirportRepository;
import com.example.demo.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @PostMapping("/airport")
    public CreateAirportResponse createAirport(@RequestBody @Valid CreateAirportRequest request){
        return airportService.createAirport(request);
    }

    @GetMapping("/airport/{id}")
    public GetAirportResponse getAirport(@PathVariable("id")Long id){
        return airportService.getAirport(id);
    }
}
