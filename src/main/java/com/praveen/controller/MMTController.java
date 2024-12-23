package com.praveen.controller;

import com.praveen.model.Passenger;
import com.praveen.model.Ticket;
import com.praveen.service.MakeMyTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MMTController {

    @Autowired
    private MakeMyTripService makeMyTripService;

    @PostMapping(value = "/ticketbooking",consumes = "application/json",produces = "application/json")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger){
        Ticket ticket = makeMyTripService.bookTicket(passenger);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getTicket/{ticketNumber}",produces = "application/json")
    public Ticket getTicket(@PathVariable("ticketNumber")Integer ticketNum){
        return makeMyTripService.getTicket(ticketNum);
    }
}
