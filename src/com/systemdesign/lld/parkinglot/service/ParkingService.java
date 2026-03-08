package com.systemdesign.lld.parkinglot.service;

import com.systemdesign.lld.parkinglot.model.ParkingSpot;
import com.systemdesign.lld.parkinglot.model.Ticket;
import com.systemdesign.lld.parkinglot.model.Vehicle;
import com.systemdesign.lld.parkinglot.repo.TicketRepository;
import com.systemdesign.lld.parkinglot.service.spot.SpotAllocationStrategy;

public class ParkingService {

    private SpotAllocationStrategy strategy;
    private TicketRepository repository;

    public ParkingService(SpotAllocationStrategy strategy,
                          TicketRepository repository) {

        this.strategy = strategy;
        this.repository = repository;
    }

    public Ticket parkVehicle(Vehicle vehicle) {

        ParkingSpot spot = strategy.allocateSpot(vehicle.getType());

        if (spot == null) {
            throw new RuntimeException("Parking Full");
        }

        spot.parkVehicle(vehicle);

        Ticket ticket = new Ticket(
                spot.getSpotId(),
                spot.getFloorNumber(),
                vehicle.getVehicleNumber()
        );

        repository.save(ticket);

        return ticket;
    }
}
