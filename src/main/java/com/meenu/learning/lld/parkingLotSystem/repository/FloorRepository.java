package com.meenu.learning.lld.parkingLotSystem.repository;


import com.meenu.learning.lld.parkingLotSystem.domain.Floor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class FloorRepository {
    private Map<UUID, Floor> floors = new HashMap<>();
    private Map<Integer, UUID> floorNumberToId = new HashMap<>();

    public Floor save(Floor floor) {
        floors.put(floor.getFloorId(), floor);
        floorNumberToId.put(floor.getFloorNumber(), floor.getFloorId());
        return floor;
    }

    public Floor findById(UUID floorId) {
        return floors.get(floorId);
    }

    public Floor findByNumber(Integer floorNumber) {
        UUID id = floorNumberToId.get(floorNumber);
        return floors.get(id);
    }


}
