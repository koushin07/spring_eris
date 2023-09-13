package com.inventory.eris.domain.administratives.officepersonnel;

import java.util.Optional;

public interface OfficePersonnelDao {
    OfficePersonnel saveOfficePersonnel(OfficePersonnel officePersonnel);

    Optional<OfficePersonnel> selectOfficePersonnelById(Long id);
    void deactivatePersonnel(Long id);
}
