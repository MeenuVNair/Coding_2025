package com.meenu.learning.lld.parkingLotSystem.controller;


import com.meenu.learning.lld.parkingLotSystem.domain.PricingRule;
import com.meenu.learning.lld.parkingLotSystem.domain.Vehicle;
import com.meenu.learning.lld.parkingLotSystem.service.AdminService;

/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */


public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    public void initializeParkingLot() {
        System.out.println("[AdminController] Admin request to initialize parking lot");
        adminService.initializeParkingLot();
        System.out.println("[AdminController] Parking lot initialized successfully by admin");
    }

    public void addFloor(int floorNumber) {
        System.out.println("[AdminController] Admin request to add floor: " + floorNumber);
        adminService.addFloor(floorNumber);
        System.out.println("[AdminController] Floor added successfully by admin");
    }

    public void addSlotsToFloor(int floorNumber, Vehicle.VehicleType slotType, int count) {
        System.out.println("[AdminController] Admin request to add " + count + " " + slotType + " slots to floor " + floorNumber);
        adminService.addSlotsToFloor(floorNumber, slotType, count);
        System.out.println("[AdminController] Slots added successfully by admin");
    }

    public void updatePricingRule(Vehicle.VehicleType vehicleType, double ratePerHour, double flatRate) {
        System.out.println("[AdminController] Admin request to update pricing for " + vehicleType);
        adminService.updateRules(vehicleType, ratePerHour, flatRate);
        System.out.println("[AdminController] Pricing rule updated successfully by admin");
    }

    public void updateFlatPricing(Vehicle.VehicleType vehicleType, double flatRate) {
        System.out.println("[AdminController] Admin request to update flat pricing for " + vehicleType + " to " + flatRate);
        adminService.updateFlatPrice(vehicleType, flatRate);
        System.out.println("[AdminController] Flat pricing updated successfully by admin");
    }

    public void updateHourlyPricing(Vehicle.VehicleType vehicleType, double ratePerHour) {
        System.out.println("[AdminController] Admin request to update hourly pricing for " + vehicleType + " to " + ratePerHour);
        adminService.updateRatePerHour(vehicleType, ratePerHour);
        System.out.println("[AdminController] Hourly pricing updated successfully by admin");
    }

    public void addPricingRule(Vehicle.VehicleType vehicleType, PricingRule rule) {
        System.out.println("[AdminController] Admin request to add new pricing rule for " + rule.getVehicleType());
        adminService.addPricingRule(vehicleType, rule);
        System.out.println("[AdminController] Pricing rule added successfully by admin");
    }
}

