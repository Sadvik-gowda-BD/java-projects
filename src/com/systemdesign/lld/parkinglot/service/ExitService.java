package com.systemdesign.lld.parkinglot.service;

import com.systemdesign.lld.parkinglot.model.ParkingLot;
import com.systemdesign.lld.parkinglot.model.ParkingSpot;
import com.systemdesign.lld.parkinglot.model.Ticket;
import com.systemdesign.lld.parkinglot.repo.TicketRepository;
import com.systemdesign.lld.parkinglot.service.spot.SpotAllocationStrategy;

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