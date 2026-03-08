package com.systemdesign.lld.parkinglot.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {

    private String ticketId;
    private int spotId;
    private int floorNumber;
    private String vehicleNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;

    public Ticket(int spotId, int floorNumber, String vehicleNumber) {
        this.ticketId = UUID.randomUUID().toString();
        this.spotId = spotId;
        this.floorNumber = floorNumber;
        this.vehicleNumber = vehicleNumber;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ACTIVE;
    }

    public String getTicketId() {
        return ticketId;
    }

    public int getSpotId() {
        return spotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
        this.status = TicketStatus.PAID;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }
}
