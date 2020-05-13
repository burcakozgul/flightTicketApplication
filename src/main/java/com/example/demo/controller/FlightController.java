package com.example.demo.controller;

import com.example.demo.model.CreateFlightRequest;
import com.example.demo.model.CreateFlightResponse;
import com.example.demo.model.GetFlightResponse;
import com.example.demo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired
    private FlightService service;

    @PostMapping("/flight")
    public CreateFlightResponse createFlight(@RequestBody @Valid CreateFlightRequest request){
        return service.createFlight(request);
    }

    @GetMapping("/flight/{id}")
    public GetFlightResponse getFlight(@PathVariable("id")Long id){
        return service.getFlight(id);
    }

}
