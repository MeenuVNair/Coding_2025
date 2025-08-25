package com.meenu.learning.lld.parkingLotSystem.domain;


import java.time.LocalDateTime;
import java.util.UUID;

/**
* @author Meenu V. Nair
* @created 25/08/25
*/

public class Ticket {
    private UUID ticketId;
    private UUID vehicleId;
    private Vehicle.VehicleType vehicleType;
    private UUID slotId;
    private LocalDateTime entryTime;
    private boolean isActive;

    public Ticket(UUID vehicleId, Vehicle.VehicleType vehicleType, UUID slotId) {
        this.ticketId = UUID.randomUUID();
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.slotId = slotId;
        this.isActive = true;
        this.entryTime = LocalDateTime.now();
    }

    public void deactivate() {
        this.isActive = false;
    }

    //getters

    public UUID getTicketId() {
        return ticketId;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public Vehicle.VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", vehicleId=" + vehicleId +
                ", vehicleType=" + vehicleType +
                ", slotId=" + slotId +
                ", entryTime=" + entryTime +
                ", isActive=" + isActive +
                '}';
    }
}
