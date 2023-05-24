package com.inventory.eris.domain.administratives.Personnel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonnelServiceImp implements PersonnelService{

    private final PersonnelDao personnelDao;
    @Override
    public boolean savePersonnel(Personnel personnel) {

        int saved = personnelDao.savePersonnel(personnel);
        if(saved == 0) return false;

        return true;

    }

    @Override
    public Personnel selectPersonnelById(Long id) {
        return personnelDao.selectPersonnelById(id).orElseThrow(()-> new RuntimeException("personnel not found"));

    }
}
