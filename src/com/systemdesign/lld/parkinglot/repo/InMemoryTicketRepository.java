package com.systemdesign.lld.parkinglot.repo;

import com.systemdesign.lld.parkinglot.model.Ticket;

import java.util.*;

public class InMemoryTicketRepository implements TicketRepository {

    private Map<String, Ticket> store = new HashMap<>();

    @Override
    public void save(Ticket ticket) {
        store.put(ticket.getTicketId(), ticket);
    }

    @Override
    public Ticket find(String ticketId) {
        return store.get(ticketId);
    }
}
