package com.inventory.eris.domain.equipmentmanagement.equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {
    Equipment saveEquipment(Equipment equipment);

    List<Equipment> allEquipment();

    Optional<Equipment> selectEquipment(Long id);


}
