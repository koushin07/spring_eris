package com.inventory.eris.domain.administratives.municipality;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MunicipalityServiceImp implements MunicipalityService{

    private final MunicipalityDao municipalityDao;
    @Override
    public Municipality saveMunicipality(Municipality municipality) {
        return municipalityDao.saveMunicipality(municipality)
    }

    @Override
    public Optional<Municipality> selectMunicipality(Long id) {
        return Optional.ofNullable(municipalityDao.selectMunicipality(id).orElseThrow(() -> new RuntimeException("not found")));
    }
}
