package com.inventory.eris.domain.equipmentmanagement.equipment;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Builder
@Data
public class Equipment {

    private Long equipmentId;
    private String equipmentName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
