package com.inventory.eris.domain.administratives.office;

import java.util.List;
import java.util.Optional;


public interface OfficeDao {
    List<Office> allOffice();

    Optional<Office> selectoffice(Long id);

    int saveOffice(Office office);

    Office updateOffice(Long id, Office office);

    void deleteOffice(Long id);

    Optional<Office> findByEmail(String email);

}
