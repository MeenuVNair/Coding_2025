package com.meenu.learning.lld.parkingLotSystem.service;


import com.meenu.learning.lld.parkingLotSystem.domain.ParkingSlot;
import com.meenu.learning.lld.parkingLotSystem.domain.Vehicle;
import com.meenu.learning.lld.parkingLotSystem.repository.SlotRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class SlotService {
    private SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public int getAvailableSlotsCount(Vehicle.VehicleType vehicleType) {
        return slotRepository.findSlotsByVehicleType(vehicleType).size();
    }

    public ParkingSlot allocateSlot(Vehicle.VehicleType vehicleType) {
        System.out.println("[SlotService] Allocating slot for vehicle type: " + vehicleType);
        return slotRepository.allocateSlot(vehicleType);
    }

    public void releaseSlot(UUID slotId) {
        System.out.println("[SlotService] Releasing slot: " + slotId);
        slotRepository.releaseSlot(slotId);
    }

    public ParkingSlot createSlot(Vehicle.VehicleType slotType, int floorNumber) {
        ParkingSlot slot = new ParkingSlot(floorNumber, slotType);
        slotRepository.allocateSlot(slotType);
        return slot;
    }
}
