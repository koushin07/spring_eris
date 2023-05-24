package com.inventory.eris.domain.administratives.assignoffice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignOfficeServiceImp implements  AssignOfficeService{

    private final AssignOfficeRepository assignOfficeRepository;
    @Override
    public int saveAssignOffice(AssignOffice assignOffice) {
        int saved = assignOfficeRepository.saveAssign(assignOffice);

        return saved;
    }

    @Override
    public Optional<AssignOffice> selectAssignOfficeById(Long id) {
        return assignOfficeRepository.selectAssignByRegionId(id);
    }

    @Override
    public Optional<AssignOffice> selectAssignOfficeByMunicipalityId(Long municipalityId) {
        return assignOfficeRepository.selectAssignByMunicipalityId(municipalityId);
    }
}
