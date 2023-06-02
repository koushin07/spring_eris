package com.inventory.eris.domain.administratives.municipality;

import java.util.List;
import java.util.Optional;

public interface MunicipalityService {
    Municipality saveMunicipality(Municipality municipality);
    Municipality selectMunicipality(Long id);

    List<Municipality> selectAllMunicipality();

    void updateMunicipality(Long id, String request);
}
