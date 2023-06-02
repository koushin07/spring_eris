package com.inventory.eris.domain.administratives.Personnel;

import java.util.Optional;

public interface PersonnelDao {
    Personnel savePersonnel(Personnel personnel);
    Optional<Personnel> selectPersonnelById(Long id);
}
