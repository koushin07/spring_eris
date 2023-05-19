package com.inventory.eris.domain.administratives.region;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Region {

    private Long regionId;
    private String regionName;
    private LocalDateTime createdAt;

}
