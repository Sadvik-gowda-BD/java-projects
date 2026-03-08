package com.systemdesign.lld.parkinglot.service.spot;

import com.systemdesign.lld.parkinglot.model.ParkingFloor;
import com.systemdesign.lld.parkinglot.model.ParkingSpot;
import com.systemdesign.lld.parkinglot.model.VehicleType;

import java.util.*;

public class NearestSpotStrategy implements SpotAllocationStrategy {

    private Map<VehicleType, Queue<ParkingSpot>> availableSpots = new HashMap<>();

    public NearestSpotStrategy(List<ParkingFloor> floors) {

        for (VehicleType type : VehicleType.values()) {

            availableSpots.put(type,
                    new PriorityQueue<>(Comparator
                            .comparingInt(ParkingSpot::getFloorNumber)
                            .thenComparingInt(ParkingSpot::getSpotId)));
        }

        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {

                availableSpots.get(spot.getType()).offer(spot);
            }
        }
    }

    @Override
    public ParkingSpot allocateSpot(VehicleType type) {

        Queue<ParkingSpot> queue = availableSpots.get(type);

        if (queue == null || queue.isEmpty()) {
            return null;
        }

        return queue.poll();
    }

    @Override
    public void freeSpot(ParkingSpot spot) {

        availableSpots.get(spot.getType()).offer(spot);
    }
}
