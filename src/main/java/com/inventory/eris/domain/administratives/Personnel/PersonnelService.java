package com.inventory.eris.domain.administratives.Personnel;

import com.inventory.eris.domain.administratives.Personnel.requests.CreatePersonnelRequest;
import com.inventory.eris.domain.administratives.Personnel.requests.UpdatePersonnelRequest;

import java.util.List;
import java.util.Optional;

public interface PersonnelService {

    Personnel savePersonnel(CreatePersonnelRequest request, Long id);
    Personnel selectPersonnelById(Long id);

    List<Personnel> allPersonnel();

    void updatePersonnel(UpdatePersonnelRequest request);

}
