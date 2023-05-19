package com.inventory.eris.domain.administratives.municipality;

import java.util.Optional;

public interface MunicipalityService {
    Municipality saveMunicipality(Municipality municipality);
    Optional<Municipality> selectMunicipality(Long id);
}
