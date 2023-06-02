package com.inventory.eris.domain.administratives.province;

import com.inventory.eris.domain.administratives.municipality.Municipality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Province {
    private Long provinceId;
    private String provinceName;
    private List<Municipality> municipality;
    private LocalDateTime createdAt;

}
