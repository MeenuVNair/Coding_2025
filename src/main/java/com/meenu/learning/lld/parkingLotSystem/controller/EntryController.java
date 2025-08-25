package com.meenu.learning.lld.parkingLotSystem.controller;


import com.meenu.learning.lld.parkingLotSystem.domain.ParkingSlot;
import com.meenu.learning.lld.parkingLotSystem.domain.Ticket;
import com.meenu.learning.lld.parkingLotSystem.domain.Vehicle;
import com.meenu.learning.lld.parkingLotSystem.service.SlotService;
import com.meenu.learning.lld.parkingLotSystem.service.TicketService;

import java.util.UUID;

/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public class EntryController {
    private TicketService ticketService;
    private SlotService slotService;

    public EntryController(TicketService ticketService, SlotService slotService) {
        this.ticketService = ticketService;
        this.slotService = slotService;
        System.out.println("EntryController initialized");
    }

    public EntryResult vehicleEntry(Vehicle.VehicleType vehicleType, String licensePlate) {
        System.out.println("[EntryController] : Vehicle entry request");
        // check slot availability for the vehicle type
        try {
            int availableSlotCount = slotService.getAvailableSlotsCount(vehicleType);
            if (availableSlotCount >= 0) {
                //if slots available, generate ticket
                ParkingSlot allocatedSlot = slotService.allocateSlot(vehicleType);

                Vehicle vehicle = new Vehicle(licensePlate, vehicleType);
                System.out.println("[EntryController] : Vehicle created , " + vehicle.getVehicleId());
                Ticket generatedTicket = ticketService.generateTicket(vehicle, allocatedSlot.getSlotId());
                System.out.println("[EntryController] : ENTRY SUCCESSFUL");
                return new EntryResult(true, generatedTicket.getTicketId(), allocatedSlot.getSlotId(), "ENTRY SUCCESSFUL");
            } else {
                System.out.println("[EntryController] : No slots available for this vehicle Type, ENTRY DENIED");
                return new EntryResult(false, null, null, "No slots available for this vehicle Type, ENTRY DENIED");
            }
        } catch (Exception e) {
            System.out.println("[EntryController] : ENTRY FAILED");
            return new EntryResult(false, null, null, e.getMessage());
        }
    }

    public static class EntryResult {
        private final boolean success;
        private final UUID ticketId;
        private final UUID slotId;
        private final String message;

        public EntryResult(boolean success, UUID ticketId, UUID slotId, String message) {
            this.success = success;
            this.ticketId = ticketId;
            this.slotId = slotId;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public UUID getTicketId() {
            return ticketId;
        }

        public UUID getSlotId() {
            return slotId;
        }

        public String getMessage() {
            return message;
        }
    }
}