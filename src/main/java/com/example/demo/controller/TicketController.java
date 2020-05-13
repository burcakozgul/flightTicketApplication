package com.example.demo.controller;

import com.example.demo.model.CreateTicketRequest;
import com.example.demo.model.CreateTicketResponse;
import com.example.demo.model.GetTicketResponse;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/ticket")
    public CreateTicketResponse createTicket(@RequestBody CreateTicketRequest request){
        return ticketService.createTicket(request);
    }

    @DeleteMapping("/ticket/{id}")
    public void removeTicket(@PathVariable("id")long id){
        ticketRepository.deleteById(id);
    }

    @GetMapping("/ticket/{id}")
    public GetTicketResponse getTicket(@PathVariable("id")long id){
        return ticketService.getTicket(id);
    }

}
