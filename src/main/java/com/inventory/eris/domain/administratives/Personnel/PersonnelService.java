package com.inventory.eris.domain.administratives.Personnel;

import java.util.Optional;

public interface PersonnelService {

    Personnel savePersonnel(Personnel personnel);
    Personnel selectPersonnelById(Long id);
}
