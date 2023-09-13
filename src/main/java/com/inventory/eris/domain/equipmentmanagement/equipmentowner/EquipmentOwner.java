package com.inventory.eris.domain.equipmentmanagement.equipmentowner;

import com.inventory.eris.domain.administratives.office.Office;
import com.inventory.eris.domain.equipmentmanagement.equipment.Equipment;
import com.inventory.eris.domain.equipmentmanagement.equipmentattribute.EquipmentAttribute;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class EquipmentOwner {

    private Long equipmentOwnerId;
    private Office office;
    private Equipment equipment;
    private EquipmentAttribute equipmentAttribute;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

