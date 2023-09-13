package com.inventory.eris.domain.equipmentmanagement.equipment.request;

import com.inventory.eris.domain.equipmentmanagement.equipmentattribute.EquipmentCategory;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EquipmentUpdateRequest {

    private Long equipmentId;
    private Long EAttributeId;
    private String serialNumber;
    private String assetDescription;
    private String code;
    private String modelNumber;
    private String unit;
    private Integer assetId;
    private EquipmentCategory category;
    private String remark;
}
