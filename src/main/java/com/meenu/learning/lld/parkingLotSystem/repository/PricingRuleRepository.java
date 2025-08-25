package com.meenu.learning.lld.parkingLotSystem.repository;


import com.meenu.learning.lld.parkingLotSystem.domain.PricingRule;
import com.meenu.learning.lld.parkingLotSystem.domain.Vehicle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class PricingRuleRepository {
    private Map<Vehicle.VehicleType, PricingRule> vehicleTypeToRule = new HashMap<>();

    public void save(Vehicle.VehicleType vehicleType, PricingRule rule) {
        vehicleTypeToRule.put(vehicleType, rule);
    }

    public PricingRule getPricingRule(Vehicle.VehicleType vehicleType) {
        return vehicleTypeToRule.get(vehicleType);
    }

    public void updateRule(Vehicle.VehicleType vehicleType, PricingRule rule) {
        if(vehicleTypeToRule.containsKey(vehicleType))
            vehicleTypeToRule.put(vehicleType, rule);
    }

}
