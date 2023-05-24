package com.inventory.eris.domain.administratives.assignoffice;

import java.util.Optional;

public interface AssignOfficeDao {
    int saveAssign(AssignOffice assignOffice);
    Optional<AssignOffice> selectAssign(Long id);
    Optional<AssignOffice> selectAssignByRegionId(Long regionId);
    Optional<AssignOffice> selectAssignByMunicipalityId(Long municipalityId);
    Optional<AssignOffice> selectAssignByProvinceId(Long provinceId);


}
