package com.inventory.eris.domain.administratives.assignoffice;

import com.inventory.eris.domain.administratives.province.Province;

import java.util.List;
import java.util.Optional;

public interface AssignOfficeService {

    AssignOffice saveAssignOffice(AssignOffice assignOffice);
    Optional<AssignOffice> selectAssignOfficeById(Long id);

    Optional<AssignOffice> selectAssignOfficeByMunicipalityId(Long municipalityId);

    List<Province> selectAssignProvinceAll();
}
