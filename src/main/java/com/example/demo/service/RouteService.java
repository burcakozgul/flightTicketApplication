package com.example.demo.service;

import com.example.demo.entity.Route;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.exception.GeneralException;
import com.example.demo.model.CreateRouteRequest;
import com.example.demo.model.CreateRouteResponse;
import com.example.demo.model.GetRouteResponse;
import com.example.demo.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public CreateRouteResponse createRoute(CreateRouteRequest request) {
        Route route = new Route();
        CreateRouteResponse response = new CreateRouteResponse();
        try {
            route.setRouteCode(request.getRouteCode());
            route.setFrom(request.getFrom());
            route.setDestination(request.getDestination());
            route.setDistance(request.getDistance());
            route.setDate(request.getDate());
            routeRepository.save(route);
            response.setResultCode(0);
            response.setResultDesc("Success");
        }
        catch (Exception e){
            response.setResultCode(ErrorCodes.GENERAL_ERROR);
            response.setResultDesc("GENERAL ERROR");
        }
        return response;
    }

    public GetRouteResponse getRoute(Long id) {
        GetRouteResponse response = new GetRouteResponse();
        try {
            Route route = routeRepository.findById(id).filter(route1 -> Objects.nonNull(route1))
                    .orElseThrow(()-> new GeneralException("Route Id is not exist",ErrorCodes.ROUTE_ID_IS_NOT_EXIST));
            response.setRoute(route);
            response.setResultCode(0);
            response.setResultDes("Success");
        }
        catch (GeneralException e){
            response.setResultCode(e.getErrorCode());
            response.setResultDes(e.getMessage());
        }
        catch (Exception e){
            response.setResultCode(ErrorCodes.GENERAL_ERROR);
            response.setResultDes("GENERAL EXCEPTION");
        }
        return response;
    }
}
