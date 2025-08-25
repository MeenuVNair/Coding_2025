package com.meenu.learning.lld.parkingLotSystem.main;


import com.meenu.learning.lld.parkingLotSystem.adapter.RazorPayAdapter;
import com.meenu.learning.lld.parkingLotSystem.controller.AdminController;
import com.meenu.learning.lld.parkingLotSystem.controller.EntryController;
import com.meenu.learning.lld.parkingLotSystem.controller.ExitController;
import com.meenu.learning.lld.parkingLotSystem.domain.PricingRule;
import com.meenu.learning.lld.parkingLotSystem.domain.Vehicle;
import com.meenu.learning.lld.parkingLotSystem.repository.*;
import com.meenu.learning.lld.parkingLotSystem.service.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class ParkingLot {
    public static void main(String[] args) {
        System.out.println("=== PARKING LOT LLD SIMULATION ===");
        System.out.println("This simulation demonstrates the complete parking lot system flow\n");

        // Initialize repositories
        TicketRepository ticketRepository = new TicketRepository();
        SlotRepository slotRepository = new SlotRepository();
        FloorRepository floorRepository = new FloorRepository();
        PricingRuleRepository pricingRuleRepository = new PricingRuleRepository();
        PaymentRepository paymentRepository = new PaymentRepository();

        // Initialize services
        TicketService ticketService = new TicketService(ticketRepository);
        SlotService slotService = new SlotService(slotRepository);
        PricingService pricingService = new PricingService(pricingRuleRepository);
        PaymentService paymentService = new PaymentService(paymentRepository, new RazorPayAdapter());
        ReceiptService receiptService = new ReceiptService();
        AdminService adminService = new AdminService(floorRepository, slotRepository, pricingRuleRepository);

        // Initialize controllers
        EntryController entryController = new EntryController(ticketService, slotService);
        ExitController exitController = new ExitController(ticketService, slotService, paymentService, receiptService, pricingService);
        AdminController adminController = new AdminController(adminService);

        // === INITIALIZATION PHASE ===
        System.out.println("=== INITIALIZATION PHASE ===");
        adminController.initializeParkingLot();

        // === ENTRY FLOW SIMULATION ===
        System.out.println("\n=== ENTRY FLOW SIMULATION ===");

        // Simulate vehicle entries
        simulateVehicleEntry(entryController, "ABC123", Vehicle.VehicleType.CAR);
        simulateVehicleEntry(entryController, "XYZ789", Vehicle.VehicleType.BIKE);
        simulateVehicleEntry(entryController, "DEF456", Vehicle.VehicleType.TRUCK);

        // === EXIT FLOW SIMULATION ===
        System.out.println("\n=== EXIT FLOW SIMULATION ===");

        // Get active tickets for exit simulation
        List<UUID> activeTickets = ticketRepository.findActiveTickets().stream()
                .map(ticket -> ticket.getTicketId())
                .collect(Collectors.toList());
        System.out.println("Found " + activeTickets.size() + " active tickets");

        // Simulate vehicle exits
        for (UUID ticketId : activeTickets) {
            simulateVehicleExit(exitController, ticketId);
        }

        // === ADMIN OPERATIONS SIMULATION ===
        System.out.println("\n=== ADMIN OPERATIONS SIMULATION ===");
        simulateAdminOperations(adminController);

        System.out.println("\n=== SIMULATION COMPLETED ===");
    }

    private static void simulateVehicleEntry(EntryController entryController, String licensePlate, Vehicle.VehicleType vehicleType) {
        System.out.println("\n--- Vehicle Entry Simulation ---");
        EntryController.EntryResult result = entryController.vehicleEntry(vehicleType, licensePlate);

        if (result.isSuccess()) {
            System.out.println("✅ Entry successful - Ticket ID: " + result.getTicketId());
        } else {
            System.out.println("❌ Entry failed: " + result.getMessage());
        }
    }

    private static void simulateVehicleExit(ExitController exitController, UUID ticketId) {
        System.out.println("\n--- Vehicle Exit Simulation ---");
        ExitController.ExitResult result = exitController.vehicleExit(ticketId);

        if (result.isSuccess()) {
            System.out.println("✅ Exit successful - Receipt ID: " + result.getReceiptId());
            System.out.println("💰 Total Fee: $" + String.format("%.2f", result.getFee()));
            System.out.println("💳 Payment Status: SUCCESS");

            // Generate receipt text
            String receiptText = exitController.generateReceiptText(ticketId);
            System.out.println(receiptText);
        } else {
            System.out.println("❌ Exit failed: " + result.getMessage());
        }
    }

    private static void simulateAdminOperations(AdminController adminController) {
        System.out.println("\n--- Admin Operations Simulation ---");

        // Add a new floor
        adminController.addFloor(3);

        // Add slots to the new floor
        adminController.addSlotsToFloor(3, Vehicle.VehicleType.CAR, 10);
        adminController.addSlotsToFloor(3, Vehicle.VehicleType.EV, 5);

        // Update pricing for CAR
        adminController.updatePricingRule(Vehicle.VehicleType.CAR, 25.0, 60.0);

        // Update flat pricing for BIKE
        adminController.updateFlatPricing(Vehicle.VehicleType.BIKE, 35.0);

        // Update hourly pricing for TRUCK
        adminController.updateHourlyPricing(Vehicle.VehicleType.TRUCK, 40.0);

        // Add a new pricing rule for EV
        PricingRule newEvRule = new PricingRule(Vehicle.VehicleType.EV, 18.0, 50.0);
        adminController.addPricingRule(Vehicle.VehicleType.EV, newEvRule);

        System.out.println("✅ Admin operations completed successfully");
    }
}
