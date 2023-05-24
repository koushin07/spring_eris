package com.inventory.eris.domain.administratives.municipality;

import com.inventory.eris.domain.administratives.province.Province;
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
    private Province province;

    public Municipality(String municipalityName, Double latitude, Double longitude) {
        this.municipalityName = municipalityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
