package com.inventory.eris.domain.administratives.office;

import com.inventory.eris.domain.administratives.office.request.ChangePasswordRequest;
import com.inventory.eris.domain.administratives.office.request.UpdateOfficeRequest;
import com.inventory.eris.domain.administratives.office.response.UpdateOfficeResponse;

import java.util.List;
import java.util.Optional;

public interface OfficeService {

    Office saveOffice(Office office);
    List<Office> allOffices();

    Optional<Office> selectOffice(Long id);

    UpdateOfficeResponse updateOffice(Long id, UpdateOfficeRequest office);

    void changePassword(ChangePasswordRequest newPassword);

    void reassignMunicipality(Long id, Long municipalityId);
}
