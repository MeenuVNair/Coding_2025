package com.meenu.learning.lld.parkingLotSystem.repository;

import com.meenu.learning.lld.parkingLotSystem.domain.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class TicketRepository {
    private Map<UUID, Ticket> tickets = new HashMap<>();

    public Ticket save(Ticket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public Ticket findTicket(UUID ticketId) {
        return tickets.get(ticketId);
    }

    public void deactivateTicket(UUID ticketId) {
        if(tickets.containsKey(ticketId)) {
            tickets.get(ticketId).deactivate();
        }
    }

    public List<Ticket> findActiveTickets() {
        return tickets.values().stream().filter(Ticket :: isActive).collect(Collectors.toList());
    }
}
