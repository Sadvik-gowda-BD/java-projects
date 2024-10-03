package com.it.java.multithreading.project.parking;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

enum VehicleType {
    CAR, BIKE, TRUCK
}

class ParkingLot {

    private final ConcurrentHashMap<VehicleType, AtomicInteger> vehicleCount;

    public ParkingLot() {
        vehicleCount = new ConcurrentHashMap<>();
        for (VehicleType type : VehicleType.values()) {
            vehicleCount.put(type, new AtomicInteger(0));
        }
    }

    public void vehicleEntry(VehicleType type) {
        vehicleCount.get(type).incrementAndGet();
        System.out.println(type + " entered. Current count: " + vehicleCount.get(type).get());
    }

    public void vehicleExit(VehicleType type) {
        vehicleCount.get(type).decrementAndGet();
        System.out.println(type + " exited. Current count: " + vehicleCount.get(type).get());
    }

    public void displayCurrentCount() {
        System.out.println("Current vehicles in parking lot:");
        for (VehicleType type : VehicleType.values()) {
            System.out.println(type + ": " + vehicleCount.get(type).get());
        }
    }

}

class EntryGate extends Thread {
    private final ParkingLot parkingLot;

    public EntryGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        while (true) {
            try {
                VehicleType type = VehicleType.values()[ThreadLocalRandom.current().nextInt(VehicleType.values().length)];
                parkingLot.vehicleEntry(type);
                Thread.sleep(1000); // Simulate vehicle entering at intervals
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ExitGate extends Thread {
    private final ParkingLot parkingLot;

    public ExitGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        while (true) {
            try {
                VehicleType type = VehicleType.values()[ThreadLocalRandom.current().nextInt(VehicleType.values().length)];
                parkingLot.vehicleExit(type);
                Thread.sleep(1500); // Simulate vehicle exiting at intervals
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ParkingLotSimulation {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        // Create 3 entry gates (threads)
        Thread entryGate1 = new EntryGate(parkingLot);
        Thread entryGate2 = new EntryGate(parkingLot);
        Thread entryGate3 = new EntryGate(parkingLot);

        // Create 3 exit gates (threads)
        Thread exitGate1 = new ExitGate(parkingLot);
        Thread exitGate2 = new ExitGate(parkingLot);
        Thread exitGate3 = new ExitGate(parkingLot);

        // Start the threads
        entryGate1.start();
        entryGate2.start();
        entryGate3.start();
        exitGate1.start();
        exitGate2.start();
        exitGate3.start();

        // Periodically display the current count of vehicles
        while (true) {
            try {
                Thread.sleep(5000); // Display every 5 seconds
                parkingLot.displayCurrentCount();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
