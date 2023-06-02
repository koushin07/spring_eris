package com.inventory.eris.domain.administratives.assignoffice;

import com.inventory.eris.domain.administratives.province.Province;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignOfficeServiceImp implements  AssignOfficeService{

    private final AssignOfficeRepository assignOfficeRepository;
    @Override
    public AssignOffice saveAssignOffice(AssignOffice assignOffice) {
        return assignOfficeRepository.saveAssign(assignOffice);

    }

    @Override
    public Optional<AssignOffice> selectAssignOfficeById(Long id) {
        return assignOfficeRepository.selectAssign(id);
    }

    @Override
    public Optional<AssignOffice> selectAssignOfficeByMunicipalityId(Long municipalityId) {
        return assignOfficeRepository.selectAssignByMunicipalityId(municipalityId);
    }

    @Override
    public List<Province> selectAssignProvinceAll() {
        return assignOfficeRepository.selectAssignProvinceAll();
    }
}
