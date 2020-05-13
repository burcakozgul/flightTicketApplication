package com.example.demo.service;

import com.example.demo.entity.Flight;
import com.example.demo.entity.Route;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.exception.GeneralException;
import com.example.demo.model.CreateFlightRequest;
import com.example.demo.model.CreateFlightResponse;
import com.example.demo.model.GetFlightResponse;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private RouteRepository routeRepository;


    public CreateFlightResponse createFlight(CreateFlightRequest request) {
        CreateFlightResponse response = new CreateFlightResponse();
        Flight flight = new Flight();
        try {
            if (!routeRepository.existsByRouteCode(request.getRouteCode())){
                throw new GeneralException("Route code is not exist",ErrorCodes.ROUTE_ID_IS_NOT_EXIST);}
            flight.setAvailableSeat(request.getAvailableSeat());
            flight.setFlightCode(request.getFlightCode());
            flight.setRouteCode(request.getRouteCode());
            flight.setTotalSeat(request.getTotalSeat());
            response.setResultDesc("Success");
            response.setResultCode(0);
            flightRepository.save(flight);
        }
        catch (GeneralException e){
            response.setResultCode(e.getErrorCode());
            response.setResultDesc(e.getMessage());
        }
        catch (Exception e){
            response.setResultDesc("GENERAL ERROR");
            response.setResultCode(ErrorCodes.GENERAL_ERROR);
        }
        return response;
    }

    public GetFlightResponse getFlight(Long id) {
        GetFlightResponse response = new GetFlightResponse();
        try {
            Flight flight = flightRepository.findById(id).filter(flight1 -> Objects.nonNull(flight1))
                    .orElseThrow(() -> new GeneralException("Flight id is not exist", ErrorCodes.FLIGHT_ID_IS_NOT_EXIST));
            response.setResultDesc("Success");
            response.setResultCode(0);
            response.setFlight(flight);
        }
        catch (GeneralException e){
            response.setResultCode(e.getErrorCode());
            response.setResultDesc(e.getMessage());
        }
        catch (Exception e){
            response.setResultCode(ErrorCodes.GENERAL_ERROR);
            response.setResultDesc("GENERAL ERROR");
        }
        return response;
    }
}
