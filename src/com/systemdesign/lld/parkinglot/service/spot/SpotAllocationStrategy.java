package com.systemdesign.lld.parkinglot.service.spot;

import com.systemdesign.lld.parkinglot.model.ParkingSpot;
import com.systemdesign.lld.parkinglot.model.VehicleType;

//This follows Open Closed Principle.
//We can add any new SpotAllocationStrategy like cheap, random, nearest etc
public interface SpotAllocationStrategy {

    ParkingSpot allocateSpot(VehicleType type);

    void freeSpot(ParkingSpot spot);
}
