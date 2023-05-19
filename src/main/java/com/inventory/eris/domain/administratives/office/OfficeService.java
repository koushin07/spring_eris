package com.inventory.eris.domain.administratives.office;

import java.util.List;
import java.util.Optional;

public interface OfficeService {
    List<Office> allOffices();

    Optional<Office> selectOffice(Long id);
}
