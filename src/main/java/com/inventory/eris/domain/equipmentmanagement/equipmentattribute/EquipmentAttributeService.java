package com.inventory.eris.domain.equipmentmanagement.equipmentattribute;

import java.util.Optional;

public interface EquipmentAttributeService {

    EquipmentAttribute saveEquipmentAttribute(EquipmentAttribute attribute);
    Optional<EquipmentAttribute> equipmentAttributeBySerial(String serial);
}
