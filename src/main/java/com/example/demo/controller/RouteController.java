package com.example.demo.controller;

import com.example.demo.model.CreateRouteRequest;
import com.example.demo.model.CreateRouteResponse;
import com.example.demo.model.GetRouteResponse;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @PostMapping("/route")
    public CreateRouteResponse createRoute(@RequestBody CreateRouteRequest request){
        return routeService.createRoute(request);
    }

    @GetMapping("/route/{id}")
    public GetRouteResponse getRoute(@PathVariable("id")Long id){
        return routeService.getRoute(id);
    }
}
