package com.inventory.eris.domain.equipmentmanagement.equipment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImp implements EquipmentService{

    private final EquipmentDao equipmentDao;
    @Override
    public Equipment saveEquipment(Equipment equipment) {

        return equipmentDao.saveEquipment(equipment);
    }

    @Override
    public List<Equipment> allEquipment() {
        return equipmentDao.selectEquipment();
    }

    @Override
    public Optional<Equipment> selectEquipment(Long id) {
        return equipmentDao.selectEquipmentById(id);
    }
}
