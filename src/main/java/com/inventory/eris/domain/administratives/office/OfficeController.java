package com.inventory.eris.domain.administratives.office;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/offices")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeService officeService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Office office){
        Office off = officeService.saveOffice(office);
        return ok("done");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Office> update(@PathVariable("id") Long id, @RequestBody Office office){
       Office updated = officeService.updateOffice(id, office);
       return ok(updated);
    }

    @PutMapping("/change-password")
    public ResponseEntity<Void> password(@RequestBody @Valid ChangePasswordRequest newPassword){
        officeService.changePassword(newPassword);
        return ok().build();
    }

}
