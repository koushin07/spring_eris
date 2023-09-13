package com.inventory.eris.domain.equipmentmanagement.equipmentattribute;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipmentAttributeServiceImp implements EquipmentAttributeService{

    private final EquipmentAttributeDao equipmentAttributeDao;
    @Override
    public EquipmentAttribute saveEquipmentAttribute(EquipmentAttribute attribute) {
      return equipmentAttributeDao.saveEquipmentAttribute(attribute);
    }

    @Override
    public Optional<EquipmentAttribute> equipmentAttributeBySerial(String serial) {
        return equipmentAttributeDao.selectEquipmentAttributeBySerialNumber(serial);
    }

}
