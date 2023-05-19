package com.inventory.eris.domain.administratives.municipality;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Municipality {

    private Long municipalityId;
    private String municipalityName;
    private Double latitude;
    private Double longitude;
    private Long provinceId;

}
