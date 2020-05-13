package com.example.demo.service;

import com.example.demo.entity.Airline;
import com.example.demo.exception.GeneralException;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.model.CreateAirlineRequest;
import com.example.demo.model.CreateAirlineResponse;
import com.example.demo.model.GetAirlineResponse;
import com.example.demo.repository.AirlineRepository;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    public CreateAirlineResponse createAirline(CreateAirlineRequest request) {
        Airline airline = new Airline();
        CreateAirlineResponse response = new CreateAirlineResponse();
        try {
            airline.setName(request.getName());
            airline.setAddress(request.getAddress());
            airline.setNumberofAircraft(request.getNumberofAircraft());
            airline.setTelephoneNumber(request.getTelephoneNumber());
            response.setResultCode(0);
            response.setResultDes("Success");
            airlineRepository.save(airline);
        }
        catch (Exception e){
            response.setResultDes("GENERAL ERROR");
            response.setResultCode(ErrorCodes.GENERAL_ERROR);
        }
        return response;
    }


    public GetAirlineResponse getAirline(Long id) throws GeneralException {
        GetAirlineResponse response = new GetAirlineResponse();
        try {
            Airline airline = airlineRepository.findById(id).filter(airline1 -> Objects.nonNull(airline1))
                    .orElseThrow(()->new GeneralException("Airline id is not exist",ErrorCodes.AIRLINE_ID_IS_NOT_EXIST));
            response.setAirline(airline);
            response.setResultDes("Success");
            response.setResultCode(0);
        }
        catch (GeneralException e){
            response.setResultCode(e.getErrorCode());
            response.setResultDes(e.getMessage());
        }
        catch (Exception e){
            response.setResultCode(ErrorCodes.GENERAL_ERROR);
            response.setResultDes("GENERAL ERROR");
        }
        return response;
    }
}
