package com.inventory.eris.domain.administratives.Personnel;

import com.inventory.eris.domain.administratives.Personnel.requests.CreatePersonnelRequest;
import com.inventory.eris.domain.administratives.Personnel.requests.UpdatePersonnelRequest;
import com.inventory.eris.domain.administratives.assignoffice.AssignOfficeDao;
import com.inventory.eris.domain.administratives.office.Office;
import com.inventory.eris.domain.administratives.office.OfficeDao;
import com.inventory.eris.domain.administratives.officepersonnel.OfficePersonnel;
import com.inventory.eris.domain.administratives.officepersonnel.OfficePersonnelDao;
import com.inventory.eris.utils.Exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonnelServiceImp implements PersonnelService{

    private final PersonnelDao personnelDao;
    private final OfficeDao officeDao;
    private final OfficePersonnelDao officePersonnelDao;
    @Override
    @Transactional
    public Personnel savePersonnel(CreatePersonnelRequest request, Long id) {

        officePersonnelDao.deactivatePersonnel(id);
        Personnel personnel = personnelDao.savePersonnel(Personnel.builder()
                .firstName(request.firstName())
                .middleName(request.middleName())
                .lastName(request.lastName())
                .suffix(request.suffix())
                .build());

        Office office = officeDao.selectoffice(request.OfficeId())
                .orElseThrow(()-> new ResourceNotFoundException("no office found"));

        OfficePersonnel officePersonnel = officePersonnelDao.saveOfficePersonnel(OfficePersonnel.builder()
                .office(office)
                .personnel(personnel).build());
        return   personnel;
    }

    @Override
    public Personnel selectPersonnelById(Long id) {
        return personnelDao.selectPersonnelById(id).orElseThrow(()-> new RuntimeException("personnel not found"));

    }

    @Override
    public List<Personnel> allPersonnel() {
        return personnelDao.allPersonnel();
    }

    @Override
    public void updatePersonnel(UpdatePersonnelRequest request) {
        Personnel personnel = Personnel.builder()
                .personnelId(request.PersonnelId())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .middleName(request.middleName())
                .suffix(request.suffix())
                .build();

        personnelDao.updatePersonnel(personnel);
    }
}
