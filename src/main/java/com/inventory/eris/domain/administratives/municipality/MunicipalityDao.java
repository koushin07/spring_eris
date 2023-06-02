package com.inventory.eris.domain.administratives.municipality;

import java.util.List;
import java.util.Optional;

public interface MunicipalityDao {
    Municipality saveMunicipality(Municipality municipality);
    Optional<Municipality> selectMunicipality(Long id);

    List<Municipality> selectAllMunicipality();


    void updateMunicipality(Long id, String rename);
}
