package com.inventory.eris.domain.administratives.officepersonnel;

import java.util.Optional;

public interface OfficePersonnelDao {
    int saveOfficePersonnel(OfficePersonnel officePersonnel);

    Optional<OfficePersonnel> selectOfficePersonnelById(Long id);
}
