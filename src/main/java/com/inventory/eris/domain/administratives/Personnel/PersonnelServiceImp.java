package com.inventory.eris.domain.administratives.Personnel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonnelServiceImp implements PersonnelService{

    private final PersonnelDao personnelDao;
    @Override
    public Personnel savePersonnel(Personnel personnel) {

        return   personnelDao.savePersonnel(personnel);


    }

    @Override
    public Personnel selectPersonnelById(Long id) {
        return personnelDao.selectPersonnelById(id).orElseThrow(()-> new RuntimeException("personnel not found"));

    }
}
