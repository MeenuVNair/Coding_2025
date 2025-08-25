package com.meenu.learning.lld.parkingLotSystem.service;


import com.meenu.learning.lld.parkingLotSystem.domain.Floor;
import com.meenu.learning.lld.parkingLotSystem.domain.ParkingSlot;
import com.meenu.learning.lld.parkingLotSystem.domain.PricingRule;
import com.meenu.learning.lld.parkingLotSystem.domain.Vehicle;
import com.meenu.learning.lld.parkingLotSystem.repository.FloorRepository;
import com.meenu.learning.lld.parkingLotSystem.repository.PricingRuleRepository;
import com.meenu.learning.lld.parkingLotSystem.repository.SlotRepository;

import java.util.Objects;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class AdminService {
    private FloorRepository floorRepository;
    private SlotRepository slotRepository;
    private PricingRuleRepository pricingRuleRepository;

    public AdminService(FloorRepository floorRepository, SlotRepository slotRepository, PricingRuleRepository pricingRuleRepository) {
        this.floorRepository = floorRepository;
        this.slotRepository = slotRepository;
        this.pricingRuleRepository = pricingRuleRepository;
    }

    public void initializeParkingLot() {
        System.out.println("[AdminService] Initializing parking lot with default configuration");
        for(int i = 0; i < 3; i++) {
            addFloor(i);
        }
        // Add slots to floor 0
        addSlotsToFloor(0, Vehicle.VehicleType.BIKE, 20);
        addSlotsToFloor(0, Vehicle.VehicleType.CAR, 30);
        addSlotsToFloor(0, Vehicle.VehicleType.TRUCK, 5);

        // Add slots to floor 1
        addSlotsToFloor(1, Vehicle.VehicleType.CAR, 40);
        addSlotsToFloor(1, Vehicle.VehicleType.EV, 10);

        // Add slots to floor 2
        addSlotsToFloor(2, Vehicle.VehicleType.CAR, 35);
        addSlotsToFloor(2, Vehicle.VehicleType.EV, 15);

        // Initialize default pricing rules
        initializeDefaultPricingRules();
    }

    public void addFloor(int floorNumber) {
        System.out.println("[AdminService] Adding floor with number: " + floorNumber);
        if(Objects.nonNull(floorRepository.findByNumber(floorNumber))) {
            System.out.println("Floor number " + floorNumber + " exists: true");
            return;
        }
        Floor floor = new Floor(floorNumber);
        floorRepository.save(floor);
        System.out.println("[AdminService] Floor added successfully: " + floor.getFloorId());
    }

    public void addSlotsToFloor(int floorNumber, Vehicle.VehicleType slotType, int count) {
        System.out.println("[AdminService] Adding " + count + " slots of type " + slotType + " to floor " + floorNumber);
        Floor floor = floorRepository.findByNumber(floorNumber);
        if(Objects.isNull(floor))
            throw new IllegalStateException("Floor " + floorNumber + " not found");

        for(int i = 0; i < count; i++) {
            ParkingSlot slot = new ParkingSlot(floorNumber, slotType);
            slotRepository.addSlot(slot);
            floor.addSlot(slot);
        }
        System.out.println("[AdminService] Added " + count + " slots to floor " + floorNumber);
    }

    private void initializeDefaultPricingRules() {
        System.out.println("Initializing default pricing rules");
        PricingRule bikeRule = new PricingRule(Vehicle.VehicleType.BIKE, 10.0, 30.0);
        PricingRule carRule = new PricingRule(Vehicle.VehicleType.CAR, 20.0, 60.0);
        PricingRule truckRule = new PricingRule(Vehicle.VehicleType.TRUCK, 30.0, 90.0);
        PricingRule evRule = new PricingRule(Vehicle.VehicleType.EV, 15.0, 45);

        pricingRuleRepository.save(Vehicle.VehicleType.BIKE, bikeRule);
        pricingRuleRepository.save(Vehicle.VehicleType.CAR, carRule);
        pricingRuleRepository.save(Vehicle.VehicleType.TRUCK, truckRule);
        pricingRuleRepository.save(Vehicle.VehicleType.EV, evRule);
    }

    public void updateRules(Vehicle.VehicleType vehicleType, double ratePerHour, double flatRate) {
        System.out.println("[AdminService] Updating pricing rule for " + vehicleType);
        PricingRule pricingRule = pricingRuleRepository.getPricingRule(vehicleType);
        if(Objects.isNull(pricingRule))
            throw new IllegalStateException("Pricing rule not found for " + vehicleType);
        pricingRule.updateRates(ratePerHour, flatRate);
        pricingRuleRepository.updateRule(vehicleType, pricingRule);
    }

    public void updateFlatPrice(Vehicle.VehicleType vehicleType, double flatRate) {
        System.out.println("[AdminService] Updating flat pricing for " + vehicleType + " to " + flatRate);
        PricingRule pricingRule = pricingRuleRepository.getPricingRule(vehicleType);
        if(Objects.isNull(pricingRule))
            throw new IllegalStateException("Pricing rule not found for " + vehicleType);
        pricingRule.updateFlatRate(flatRate);
        pricingRuleRepository.updateRule(vehicleType, pricingRule);
    }

    public void updateRatePerHour(Vehicle.VehicleType vehicleType, double ratePerHour) {
        System.out.println("[AdminService] Updating hourly pricing for " + vehicleType + " to " + ratePerHour);
        PricingRule pricingRule = pricingRuleRepository.getPricingRule(vehicleType);
        if(Objects.isNull(pricingRule))
            throw new IllegalStateException("Pricing rule not found for " + vehicleType);
        pricingRule.updateRatePerHour(ratePerHour);
        pricingRuleRepository.updateRule(vehicleType, pricingRule);
    }

    public void addPricingRule(Vehicle.VehicleType vehicleType, PricingRule rule) {
        System.out.println("[AdminService] Adding new pricing rule for " + rule.getVehicleType());
        pricingRuleRepository.save(vehicleType, rule);
        System.out.println("[AdminService] Pricing rule added successfully");
    }
}
