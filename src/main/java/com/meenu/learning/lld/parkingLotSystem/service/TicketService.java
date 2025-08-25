package com.meenu.learning.lld.parkingLotSystem.service;


import com.meenu.learning.lld.parkingLotSystem.domain.Ticket;
import com.meenu.learning.lld.parkingLotSystem.domain.Vehicle;
import com.meenu.learning.lld.parkingLotSystem.repository.TicketRepository;

import java.util.UUID;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class TicketService {
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(Vehicle vehicle, UUID slot) {
        System.out.println("[TicketService] Generating ticket for vehicle: " + vehicle.getLicensePlate());
        Ticket ticket = new Ticket(vehicle.getVehicleId(), vehicle.getVehicleType(), slot);
        ticketRepository.save(ticket);
        System.out.println("[TicketService] Ticket generated successfully: " + ticket.getTicketId());
        return ticket;
    }

    public Ticket getTicket(UUID ticketId) {
        return ticketRepository.findTicket(ticketId);
    }

    public void deactivateTicket(UUID ticketId) {
        ticketRepository.deactivateTicket(ticketId);
    }
}
