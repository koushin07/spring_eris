package com.inventory.eris.domain.administratives.office;

import java.util.List;
import java.util.Optional;


public interface OfficeDao {
    List<Office> allOffice();

    Optional<Office> selectoffice(Long id);

    Office saveOffice(Office office);

    void updateOffice( Office office);

    void deleteOffice(Long id);

    Optional<Office> findByEmail(String email);

}
