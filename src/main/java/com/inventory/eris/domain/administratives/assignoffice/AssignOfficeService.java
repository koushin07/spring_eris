package com.inventory.eris.domain.administratives.assignoffice;

import java.util.Optional;

public interface AssignOfficeService {

    int saveAssignOffice(AssignOffice assignOffice);
    Optional<AssignOffice> selectAssignOfficeById(Long id);

    Optional<AssignOffice> selectAssignOfficeByMunicipalityId(Long municipalityId);

}
