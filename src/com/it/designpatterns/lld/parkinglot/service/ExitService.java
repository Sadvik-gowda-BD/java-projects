package com.it.designpatterns.lld.parkinglot.service;

import com.it.designpatterns.lld.parkinglot.model.ParkingLot;
import com.it.designpatterns.lld.parkinglot.model.ParkingSpot;
import com.it.designpatterns.lld.parkinglot.model.Ticket;
import com.it.designpatterns.lld.parkinglot.repo.TicketRepository;
import com.it.designpatterns.lld.parkinglot.service.spot.SpotAllocationStrategy;

public class ExitService {

    private TicketRepository repository;
    private PaymentService paymentService;
    private SpotAllocationStrategy strategy;
    private ParkingLot parkingLot;

    public ExitService(TicketRepository repository,
                       PaymentService paymentService,
                       SpotAllocationStrategy strategy,
                       ParkingLot parkingLot) {

        this.repository = repository;
        this.paymentService = paymentService;
        this.strategy = strategy;
        this.parkingLot = parkingLot;
    }

    public double exitVehicle(String ticketId) {

        Ticket ticket = repository.find(ticketId);

        ticket.closeTicket();

        double amount = paymentService.calculateAmount(ticket);

        ParkingSpot spot = parkingLot.findSpot(
                ticket.getFloorNumber(),
                ticket.getSpotId()
        );

        spot.removeVehicle();

        strategy.freeSpot(spot);

        return amount;
    }
}