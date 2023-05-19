package com.inventory.eris.domain.administratives.province;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Province {
    private Long provinceId;
    private ProvinceEnum provinceName;
    private Long regionId;
    private LocalDateTime createdAt;

}
