package com.inventory.eris.domain.administratives.office;

import java.util.List;
import java.util.Optional;

public interface OfficeService {

    Office saveOffice(Office office);
    List<Office> allOffices();

    Optional<Office> selectOffice(Long id);

    Office updateOffice(Long id, Office office);

    void changePassword(ChangePasswordRequest newPassword);
}
