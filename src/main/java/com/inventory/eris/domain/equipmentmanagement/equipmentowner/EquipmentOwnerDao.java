package com.inventory.eris.domain.equipmentmanagement.equipmentowner;

import com.inventory.eris.domain.administratives.office.Office;
import com.inventory.eris.domain.equipmentmanagement.equipment.Equipment;

import java.util.Optional;

public interface EquipmentOwnerDao {

    EquipmentOwner saveEquipmentOwner(EquipmentOwner equipmentOwner);
    Optional<EquipmentOwner> selectEquipmentOwnerById(Long id);
    Optional<EquipmentOwner> selectEquipmentOwnerByOffice(Office office);
    Optional<EquipmentOwner> selectEquipmentOwnerByEquipmentId(Equipment equipment);


}
