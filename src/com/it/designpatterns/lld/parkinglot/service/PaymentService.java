package com.it.designpatterns.lld.parkinglot.service;

import com.it.designpatterns.lld.parkinglot.model.Ticket;

import java.time.Duration;

public class PaymentService {

    public double calculateAmount(Ticket ticket) {

        long hours = Duration.between(
                ticket.getEntryTime(),
                ticket.getExitTime()
        ).toHours();

        if (hours == 0) hours = 1;

        return hours * 50;
    }
}
