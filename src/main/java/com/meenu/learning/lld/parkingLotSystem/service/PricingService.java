package com.meenu.learning.lld.parkingLotSystem.service;


import com.meenu.learning.lld.parkingLotSystem.domain.PricingRule;
import com.meenu.learning.lld.parkingLotSystem.domain.Ticket;
import com.meenu.learning.lld.parkingLotSystem.domain.Vehicle;
import com.meenu.learning.lld.parkingLotSystem.repository.PricingRuleRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class PricingService {
    private PricingRuleRepository pricingRuleRepository;

    public PricingService(PricingRuleRepository pricingRuleRepository) {
        this.pricingRuleRepository = pricingRuleRepository;
    }

    public double calculateFee(Ticket ticket) {
        System.out.println("[PricingService] Calculating fee for ticket: " + ticket.getTicketId());
        Vehicle.VehicleType vehicleType = ticket.getVehicleType();
        PricingRule pricingRule = pricingRuleRepository.getPricingRule(vehicleType);
        if(Objects.isNull(pricingRule))
            throw new IllegalStateException("No pricing rule found for the given Vehicle type : " + vehicleType);

        double flatRate = pricingRule.getFlatRate();
        double hourlyFee = calculateHourlyFee(ticket, pricingRule.getRatePerHour());
        double minFare = Math.min(flatRate, hourlyFee);

        System.out.println("[PricingService] Flat fee: " + flatRate + ", Hourly fee: " + hourlyFee + ", Final fee: " + hourlyFee + " for vehicle type: " + vehicleType);
        return minFare;
    }

    private double calculateHourlyFee(Ticket ticket, double ratePerHour) {
        Duration duration = Duration.between(ticket.getEntryTime(), LocalDateTime.now());
        long hours = duration.toHours();
        if(hours < 1)
            hours = 1;
        return hours * ratePerHour;
    }

    public void addPricingRule(Vehicle.VehicleType vehicleType, PricingRule pricingRule) {
        pricingRuleRepository.save(vehicleType, pricingRule);
    }

    public void updatePricingRule(Vehicle.VehicleType vehicleType, PricingRule pricingRule) {
        pricingRuleRepository.updateRule(vehicleType, pricingRule);
    }
}
