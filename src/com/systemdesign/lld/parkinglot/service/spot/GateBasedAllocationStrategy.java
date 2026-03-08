package com.systemdesign.lld.parkinglot.service.spot;

import com.systemdesign.lld.parkinglot.model.ParkingSpot;
import com.systemdesign.lld.parkinglot.model.VehicleType;

import java.util.Map;
import java.util.PriorityQueue;

class GateBasedAllocationStrategy //implements SpotAllocationStrategy
{

    Map<Integer, Map<VehicleType, PriorityQueue<ParkingSpot>>> gateSpots;

//    @Override
    public ParkingSpot allocateSpot(int gateId, VehicleType type) {

        PriorityQueue<ParkingSpot> pq =
                gateSpots.get(gateId).get(type);

        if (pq == null || pq.isEmpty()) {
            return null;
        }

        return pq.poll();
    }

    public void freeSpot(ParkingSpot spot) {

        for (Map<VehicleType, PriorityQueue<ParkingSpot>> map : gateSpots.values()) {
            map.get(spot.getType()).offer(spot);
        }
    }
}