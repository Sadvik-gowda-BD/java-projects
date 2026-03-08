package com.systemdesign.lld.parkinglot.model;

import java.util.*;

public class ParkingLot {

    private List<ParkingFloor> floors = new ArrayList<>();

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public ParkingSpot findSpot(int floorNumber, int spotId) {

        for (ParkingFloor floor : floors) {
            if (floor.getFloorNumber() == floorNumber) {
                for (ParkingSpot spot : floor.getSpots()) {
                    if (spot.getSpotId() == spotId) {
                        return spot;
                    }
                }
            }
        }
        return null;
    }
}
