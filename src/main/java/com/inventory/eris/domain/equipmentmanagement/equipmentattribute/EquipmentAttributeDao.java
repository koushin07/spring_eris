package com.inventory.eris.domain.equipmentmanagement.equipmentattribute;

import java.util.Optional;

public interface EquipmentAttributeDao {

    EquipmentAttribute saveEquipmentAttribute(EquipmentAttribute attribute);
    Optional<EquipmentAttribute> selectEquipmentAttributeBySerialNumber(String serial);
}
