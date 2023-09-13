package com.inventory.eris.domain.equipmentmanagement.equipmentattribute;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Builder
@Data
public class EquipmentAttribute {

    private Long equipmentAttributeId;
    private String serialNumber;
    private String assetDescription;
    private String code;
    private String modelNumber;
    private String unit;
    private Integer assetId;
    private EquipmentCategory category;
    private String remark;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
