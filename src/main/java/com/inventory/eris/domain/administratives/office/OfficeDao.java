package com.inventory.eris.domain.administratives.office;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface OfficeDao {
    List<Office> allOffice();

    Optional<Office> selectoffice(Long id);

    Office saveOffice(Office office);

    Office updateOffice(Long id, Office office);

    void deleteOffice(Long id);

    Optional<Office> findByEmail(String email);

}
