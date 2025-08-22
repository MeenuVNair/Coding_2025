package com.meenu.learning.lld.parkingLotSystem.domain;


import java.util.UUID;

/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public class Vehicle {
    private UUID id;
    private String licensePlate;
    private VehicleType vehicleType;

    public enum VehicleType {
        BIKE, CAR, EV, TRUCK
    }

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.id = UUID.randomUUID();
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
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
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
