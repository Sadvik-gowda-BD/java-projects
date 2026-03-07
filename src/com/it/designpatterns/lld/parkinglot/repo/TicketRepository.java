package com.it.designpatterns.lld.parkinglot.repo;

import com.it.designpatterns.lld.parkinglot.model.Ticket;

/*
Dependency Inversion
Services depend on interfaces.
 */
public interface TicketRepository {

    void save(Ticket ticket);

    Ticket find(String ticketId);
}
