package com.inventory.eris.domain.administratives.assignoffice;

import com.inventory.eris.domain.administratives.province.Province;

import java.util.List;
import java.util.Optional;

public interface AssignOfficeDao {
    AssignOffice assignMunicipality(AssignOffice assignOffice);

    AssignOffice assignProvince(AssignOffice assignOffice);
    Optional<AssignOffice> selectAssign(Long id);
    Optional<AssignOffice> selectAssignByMunicipalityId(Long municipalityId);
    Optional<AssignOffice> selectAssignByProvinceId(Long provinceId);

    List<Province> selectAssignProvinceAll();

    void reassignMunicipality(Long id, Long municipalityId);
}
