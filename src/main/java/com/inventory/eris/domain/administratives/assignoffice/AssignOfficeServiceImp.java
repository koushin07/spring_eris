package com.inventory.eris.domain.administratives.assignoffice;

import com.inventory.eris.domain.administratives.province.Province;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignOfficeServiceImp implements  AssignOfficeService{

    private final AssignOfficeDao assignOfficeDao;
    @Override
    public AssignOffice saveAssignOffice(AssignOffice assignOffice) {
        return assignOfficeDao.assignMunicipality(assignOffice);

    }

    @Override
    public Optional<AssignOffice> selectAssignOfficeById(Long id) {
        return assignOfficeDao.selectAssign(id);
    }

    @Override
    public Optional<AssignOffice> selectAssignOfficeByMunicipalityId(Long municipalityId) {
        return assignOfficeDao.selectAssignByMunicipalityId(municipalityId);
    }

    @Override
    public List<Province> selectAssignProvinceAll() {
        return assignOfficeDao.selectAssignProvinceAll();
    }

    @Override
    public void reassignMunicipality(Long id, Long municipalityId) {
            assignOfficeDao.reassignMunicipality(id, municipalityId);
    }
}
