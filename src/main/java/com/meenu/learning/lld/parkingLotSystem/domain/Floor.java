package com.meenu.learning.lld.parkingLotSystem.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
* @author Meenu V. Nair
* @created 25/08/25
*/

public class Floor {
    private UUID floorId;
    private int floorNumber;
    private List<ParkingSlot> slots;

    public Floor(int floorNumber) {
        this.floorId = UUID.randomUUID();
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public UUID getFloorId() {
        return floorId;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public void addSlot(ParkingSlot slot) {
        slots.add(slot);
    }

    public List<ParkingSlot> getAvailableSlots(Vehicle.VehicleType vehicleType) {
        List<ParkingSlot> availableSlots = new ArrayList<>();
        for(ParkingSlot slot : slots) {
            if(vehicleType == slot.getSlotType() && !slot.isOccupied())
                availableSlots.add(slot);
        }
        return availableSlots;
    }

    public int getAvailableSlotsCount(Vehicle.VehicleType vehicleType) {
        return getAvailableSlots(vehicleType).size();
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorId=" + floorId +
                ", floorNumber=" + floorNumber +
                ", slots=" + slots +
                '}';
    }
}
