package com.inventory.eris.domain.administratives.municipality;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MunicipalityServiceImp implements MunicipalityService{

    private final MunicipalityDao municipalityDao;
    @Override
    public Municipality saveMunicipality(Municipality municipality) {
        return municipalityDao.saveMunicipality(municipality);
    }

    @Override
    public Municipality selectMunicipality(Long id) {
        return municipalityDao.selectMunicipality(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<Municipality> selectAllMunicipality() {
        return municipalityDao.selectAllMunicipality();
    }

//    ONLY THE NAME SHOULD BE UPDATED
    @Override
    public void updateMunicipality(Long id, String rename) {
        Municipality municipality = municipalityDao.selectMunicipality(id)
                .orElseThrow(()-> new RuntimeException("municipality not found"));

        municipality.setMunicipalityName(rename);

        municipalityDao.updateMunicipality(id, rename);
    }
}
