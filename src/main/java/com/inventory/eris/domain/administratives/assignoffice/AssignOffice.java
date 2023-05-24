package com.inventory.eris.domain.administratives.assignoffice;

import com.inventory.eris.domain.administratives.municipality.Municipality;
import com.inventory.eris.domain.administratives.province.Province;
import com.inventory.eris.domain.administratives.region.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @tableName assign_offices
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignOffice {

    private Long assignOfficeId;
    private Region region;
    private Province province;
    private Municipality municipality;
    private LocalDateTime createdAt;
}
