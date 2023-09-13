package com.inventory.eris.domain.equipmentmanagement.equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentDao {

    Equipment saveEquipment(Equipment equipment);
    Optional<Equipment> selectEquipmentById(Long id);
    List<Equipment> selectEquipment();
    void deleteEquipment(Long id);
}
