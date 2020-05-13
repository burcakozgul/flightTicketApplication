package com.example.demo.service;

import com.example.demo.entity.Flight;
import com.example.demo.entity.Ticket;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.exception.GeneralException;
import com.example.demo.model.CreateTicketRequest;
import com.example.demo.model.CreateTicketResponse;
import com.example.demo.model.GetTicketResponse;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FlightRepository flightRepository;

    @Transactional
    public CreateTicketResponse createTicket(CreateTicketRequest request) {
        CreateTicketResponse response = new CreateTicketResponse();
        Ticket ticket = new Ticket();
        try {
            if (!flightRepository.existsById(request.getFlightCode())){
                throw new GeneralException("Flight Id is not exist",ErrorCodes.FLIGHT_ID_IS_NOT_EXIST);}
            Flight flight = flightRepository.findById(request.getFlightCode()).get();
            if (flight.getAvailableSeat()==0){
                throw new GeneralException("Ticket sold out",ErrorCodes.TICKET_SOLD_OUT);
            }
            ticket.setName(request.getName());
            ticket.setSurname(request.getSurname());
            ticket.setTckn(request.getTckn());
            ticket.setFlightId(request.getFlightCode());
            ticket.setCreatedDate(request.getCreatedDate());
            ticket.setPrice(request.getPrice());
            response.setResultCode(0);
            response.setResultDesc("Success");
            ticketRepository.save(ticket);
            flightRepository.updateAvailableSeat(request.getFlightCode());
        }
        catch (GeneralException e){
            response.setResultDesc(e.getMessage());
            response.setResultCode(e.getErrorCode());
        }
        catch (Exception e){
            response.setResultCode(ErrorCodes.GENERAL_ERROR);
            response.setResultDesc("GENERAL ERROR");
        }
        return response;
    }

    public GetTicketResponse getTicket(long id) {
        GetTicketResponse response = new GetTicketResponse();
        try {
            Ticket ticket = ticketRepository.findById(id).filter(ticket1 -> Objects.nonNull(ticket1))
                    .orElseThrow(()->new GeneralException("Ticket id is not exist",ErrorCodes.TICKET_ID_IS_NOT_EXIST));
            response.setTicket(ticket);
            response.setResultCode(0);
            response.setResultDesc("Success");
        }
        catch (GeneralException e){
            response.setResultCode(e.getErrorCode());
            response.setResultDesc(e.getMessage());
        }
        catch (Exception e) {
            response.setResultDesc("GENERAL ERROR");
            response.setResultCode(ErrorCodes.GENERAL_ERROR);
        }
        return response;
    }
}
