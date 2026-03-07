package com.it.designpatterns.lld.parkinglot.service.spot;

import com.it.designpatterns.lld.parkinglot.model.ParkingSpot;
import com.it.designpatterns.lld.parkinglot.model.VehicleType;

public class CheapestSpotStrategy  implements SpotAllocationStrategy{
    @Override
    public ParkingSpot allocateSpot(VehicleType type) {
        return null;
    }

    @Override
    public void freeSpot(ParkingSpot spot) {

    }
}
