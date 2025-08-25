package com.meenu.learning.lld.parkingLotSystem.domain;


import java.util.UUID;

/**
* @author Meenu V. Nair
* @created 25/08/25
*/

public class Vehicle {
    UUID vehicleId;
    String licensePlate;
    VehicleType vehicleType;

    public enum VehicleType {
        CAR, BIKE, EV, TRUCK
    }

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.vehicleId = UUID.randomUUID();
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", licensePlate='" + licensePlate + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
