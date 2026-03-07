package com.it.designpatterns.lld.parkinglot;

import com.it.designpatterns.lld.parkinglot.model.ParkingFloor;
import com.it.designpatterns.lld.parkinglot.model.ParkingLot;
import com.it.designpatterns.lld.parkinglot.model.ParkingSpot;
import com.it.designpatterns.lld.parkinglot.model.Ticket;
import com.it.designpatterns.lld.parkinglot.model.Vehicle;
import com.it.designpatterns.lld.parkinglot.model.VehicleType;
import com.it.designpatterns.lld.parkinglot.repo.InMemoryTicketRepository;
import com.it.designpatterns.lld.parkinglot.repo.TicketRepository;
import com.it.designpatterns.lld.parkinglot.service.ExitService;
import com.it.designpatterns.lld.parkinglot.service.spot.NearestSpotStrategy;
import com.it.designpatterns.lld.parkinglot.service.ParkingService;
import com.it.designpatterns.lld.parkinglot.service.PaymentService;
import com.it.designpatterns.lld.parkinglot.service.spot.SpotAllocationStrategy;

public class Main {

    public static void main(String[] args) {

        ParkingFloor floor1 = new ParkingFloor(1);

        floor1.addSpot(new ParkingSpot(1, 1, VehicleType.CAR));
        floor1.addSpot(new ParkingSpot(2, 1, VehicleType.CAR));
        floor1.addSpot(new ParkingSpot(3, 1, VehicleType.BIKE));

        ParkingLot lot = new ParkingLot();
        lot.addFloor(floor1);

        SpotAllocationStrategy strategy =
                new NearestSpotStrategy(lot.getFloors());

        TicketRepository repo = new InMemoryTicketRepository();

        ParkingService parkingService =
                new ParkingService(strategy, repo);

        // ---------- ENTRY ----------

        Vehicle car = new Vehicle("KA01AB1234", VehicleType.CAR);

        Ticket ticket = parkingService.parkVehicle(car);

        System.out.println("Vehicle Parked");
        System.out.println("Ticket ID: " + ticket.getTicketId());
        System.out.println("Floor: " + ticket.getFloorNumber());
        System.out.println("Spot: " + ticket.getSpotId());

        // ---------- EXIT ----------

        PaymentService paymentService = new PaymentService();

        ExitService exitService =
                new ExitService(repo, paymentService, strategy, lot);

        double amount = exitService.exitVehicle(ticket.getTicketId());

        System.out.println("Vehicle Exited");
        System.out.println("Payment: " + amount);
    }
}
