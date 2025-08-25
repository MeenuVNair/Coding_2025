package com.meenu.learning.lld.parkingLotSystem.domain;


import java.util.UUID;

/**
* @author Meenu V. Nair
* @created 25/08/25
*/

public class ParkingSlot {
    private UUID slotId;
    private int floorNumber;
    private boolean isOccupied;
    private Vehicle.VehicleType slotType;

    public ParkingSlot(int floorNumber, Vehicle.VehicleType slotType) {
        this.slotId = UUID.randomUUID();
        this.floorNumber = floorNumber;
        this.slotType = slotType;
        this.isOccupied = false;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle.VehicleType getSlotType() {
        return slotType;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "slotId=" + slotId +
                ", floorNumber=" + floorNumber +
                ", isOccupied=" + isOccupied +
                ", slotType=" + slotType +
                '}';
    }
}
