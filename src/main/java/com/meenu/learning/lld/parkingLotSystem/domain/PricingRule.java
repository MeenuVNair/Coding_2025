package com.meenu.learning.lld.parkingLotSystem.domain;


import java.util.UUID;

/**
* @author Meenu V. Nair
* @created 25/08/25
*/

public class PricingRule {
    private UUID ruleId;
    private Vehicle.VehicleType vehicleType;
    private double ratePerHour;
    private double flatRate;

    public PricingRule(Vehicle.VehicleType vehicleType, double ratePerHour, double flatRate) {
        this.ruleId = UUID.randomUUID();
        this.vehicleType = vehicleType;
        this.ratePerHour = ratePerHour;
        this.flatRate = flatRate;
    }

    public void updateRates(double ratePerHour, double flatRate) {
        this.ratePerHour = ratePerHour;
        this.flatRate = flatRate;
    }

    public void updateFlatRate(double flatRate) {
        this.flatRate = flatRate;
    }

    public void updateRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    //getters

    public UUID getRuleId() {
        return ruleId;
    }

    public Vehicle.VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public double getFlatRate() {
        return flatRate;
    }

    @Override
    public String toString() {
        return "PricingRule{" +
                "ruleId=" + ruleId +
                ", vehicleType=" + vehicleType +
                ", ratePerHour=" + ratePerHour +
                ", flatRate=" + flatRate +
                '}';
    }
}
