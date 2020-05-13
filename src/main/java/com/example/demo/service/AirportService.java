package com.example.demo.service;

import com.example.demo.entity.Airport;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.exception.GeneralException;
import com.example.demo.model.CreateAirportRequest;
import com.example.demo.model.CreateAirportResponse;
import com.example.demo.model.GetAirportResponse;
import com.example.demo.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public CreateAirportResponse createAirport(CreateAirportRequest request) {
        Airport airport = new Airport();
        CreateAirportResponse response = new CreateAirportResponse();
        try {
            airport.setName(request.getName());
            airport.setAddress(request.getAddress());
            airport.setTelephoneNumber(request.getTelephoneNumber());
            airport.setAnnualPassengerCapacity(request.getAnnualPassengerCapacity());
            airport.setNumberofFlightDestinations(request.getNumberofFlightDestinations());
            airportRepository.save(airport);
            response.setResultCode(0);
            response.setResultDes("Success");
        }
        catch (Exception e){
            response.setResultCode(ErrorCodes.GENERAL_ERROR);
            response.setResultDes("GENERAL ERROR");
        }
        return response;
    }

    public GetAirportResponse getAirport(Long id) {
        GetAirportResponse response = new GetAirportResponse();
        try {
            Airport airport = airportRepository.findById(id).filter(airport1 -> Objects.nonNull(airport1))
                    .orElseThrow(()->new GeneralException("Airport Id is not exist",ErrorCodes.AIRPORT_ID_IS_NOT_EXIST));
            response.setAirport(airport);
            response.setResultCode(0);
            response.setResultDes("Success");
        }
        catch (GeneralException e){
            response.setResultDes(e.getMessage());
            response.setResultCode(e.getErrorCode());
        }
        catch (Exception e){
            response.setResultCode(ErrorCodes.GENERAL_ERROR);
            response.setResultDes("GENERAL ERROR");
        }
        return response;
    }
}
