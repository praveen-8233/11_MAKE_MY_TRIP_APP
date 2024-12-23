package com.praveen.service;

import com.praveen.model.Passenger;
import com.praveen.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService{


    private String BOOK_TICKET_URL = "http://localhost:9111/ticket";

    private String GET_TICKET_URL = "http://localhost:9111/ticket/{ticketNumber}";
    @Override
    public Ticket bookTicket(Passenger passenger) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<Ticket> responseEntity = rt.postForEntity(BOOK_TICKET_URL,passenger,Ticket.class);
        Ticket ticket = responseEntity.getBody();
        return ticket;
    }

    @Override
    public Ticket getTicket(Integer ticktNumber) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<Ticket> responseEntity = rt.getForEntity(GET_TICKET_URL,Ticket.class,ticktNumber);
        Ticket ticket = responseEntity.getBody();
        return ticket;
    }
}
