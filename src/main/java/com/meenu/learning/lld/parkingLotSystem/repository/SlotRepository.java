package com.meenu.learning.lld.parkingLotSystem.repository;


import com.meenu.learning.lld.parkingLotSystem.domain.ParkingSlot;
import com.meenu.learning.lld.parkingLotSystem.domain.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class SlotRepository {
    Map<UUID, ParkingSlot> slots = new HashMap<>();

    public ParkingSlot addSlot(ParkingSlot slot) {
        slots.put(slot.getSlotId(), slot);
        return slot;
    }

    public ParkingSlot getSlot(UUID slotId) {
        return slots.get(slotId);
    }

    public List<ParkingSlot> findSlotsByVehicleType(Vehicle.VehicleType vehicleType) {
        return slots.values().stream()
                .filter(slot -> slot.getSlotType() == vehicleType && !slot.isOccupied())
                .collect(Collectors.toList());
    }

    public ParkingSlot allocateSlot(Vehicle.VehicleType vehicleType) {
        ParkingSlot parkingSlot =  slots.values().stream()
                .filter(slot -> slot.getSlotType() == vehicleType && !slot.isOccupied())
                .findAny().orElse(null);
        if(Objects.nonNull(parkingSlot))
            parkingSlot.setOccupied(true);
        return parkingSlot;
    }

    public void releaseSlot(UUID slotId) {
        if(slots.containsKey(slotId)) {
            slots.get(slotId).setOccupied(false);
        }
    }
}

