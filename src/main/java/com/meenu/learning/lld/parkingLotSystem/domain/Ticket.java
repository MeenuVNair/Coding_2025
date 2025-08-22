package com.meenu.learning.lld.parkingLotSystem.domain;


import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public class Ticket {
    private UUID id;
    private UUID vehicleId;
    private UUID slotId;
    private LocalDateTime entryTime;
    private boolean isActive;

    public Ticket(UUID vehicleId, UUID slotId) {
        this.id = UUID.randomUUID();
        this.vehicleId = vehicleId;
        this.slotId = slotId;
        this.entryTime = LocalDateTime.now();
        this.isActive = true;
    }


    public UUID getId() {
        return id;
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
}
