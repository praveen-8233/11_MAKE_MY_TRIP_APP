package com.praveen.service;

import com.praveen.model.Passenger;
import com.praveen.model.Ticket;

public interface MakeMyTripService {

    public Ticket bookTicket(Passenger passenger);

    public Ticket getTicket(Integer ticktNumber);
}
