package com.it.designpatterns.lld.parkinglot.service.spot;

import com.it.designpatterns.lld.parkinglot.model.ParkingSpot;
import com.it.designpatterns.lld.parkinglot.model.VehicleType;

//This follows Open Closed Principle.
//We can add any new SpotAllocationStrategy like cheap, random, nearest etc
public interface SpotAllocationStrategy {

    ParkingSpot allocateSpot(VehicleType type);

    void freeSpot(ParkingSpot spot);
}
