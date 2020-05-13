package com.example.demo.controller;

import com.example.demo.exception.GeneralException;
import com.example.demo.model.CreateAirlineRequest;
import com.example.demo.model.CreateAirlineResponse;
import com.example.demo.model.GetAirlineResponse;
import com.example.demo.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AirlineController {


    @Autowired
    private AirlineService airlineService;

    @PostMapping("/airline")
    public CreateAirlineResponse createAirline(@RequestBody @Valid CreateAirlineRequest request){
        return airlineService.createAirline(request);
    }

    @GetMapping("/airline/{id}")
    public GetAirlineResponse getAirline(@PathVariable("id")Long id) throws GeneralException {
        return airlineService.getAirline(id);
    }
}
