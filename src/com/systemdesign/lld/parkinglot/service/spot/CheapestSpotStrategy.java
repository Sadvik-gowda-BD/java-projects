package com.systemdesign.lld.parkinglot.service.spot;

import com.systemdesign.lld.parkinglot.model.ParkingSpot;
import com.systemdesign.lld.parkinglot.model.VehicleType;

public class CheapestSpotStrategy  implements SpotAllocationStrategy{
    @Override
    public ParkingSpot allocateSpot(VehicleType type) {
        return null;
    }

    @Override
    public void freeSpot(ParkingSpot spot) {

    }
}
