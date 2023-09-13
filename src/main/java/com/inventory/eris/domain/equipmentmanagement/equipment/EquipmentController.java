package com.inventory.eris.domain.equipmentmanagement.equipment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    public ResponseEntity<List<Equipment>> equipments(){
        return ok(equipmentService.allEquipment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Equipment>> equipment(@PathVariable("id") Long id){
        return ok(equipmentService.selectEquipment(id));
    }




}
