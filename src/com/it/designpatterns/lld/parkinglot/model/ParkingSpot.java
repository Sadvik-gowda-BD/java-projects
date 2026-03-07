package com.it.designpatterns.lld.parkinglot.model;

public class ParkingSpot {

    private int spotId;
    private int floorNumber;
    private VehicleType type;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotId, int floorNumber, VehicleType type) {
        this.spotId = spotId;
        this.floorNumber = floorNumber;
        this.type = type;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public VehicleType getType() {
        return type;
    }

    public int getSpotId() {
        return spotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }
}