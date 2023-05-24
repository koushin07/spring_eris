package com.inventory.eris.domain.administratives.Personnel;

import java.util.Optional;

public interface PersonnelService {

    boolean savePersonnel(Personnel personnel);
    Personnel selectPersonnelById(Long id);
}
