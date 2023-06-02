package com.inventory.eris.domain.administratives.municipality;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/municipalities")
@RequiredArgsConstructor
public class MunicipalityController {

    private final MunicipalityService municipalityService;

    @GetMapping
    @PreAuthorize("hasAuthority('RDRRMC_PROVINCE')")
    public ResponseEntity<List<Municipality>> municipalities(){

        return ok(municipalityService.selectAllMunicipality());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Municipality> selectMunicipalityById(@PathVariable("id") Long id){

        return ok(municipalityService.selectMunicipality(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMunicipality(@PathVariable("id") Long id, @RequestBody String request){
        municipalityService.updateMunicipality(id, request);
        return ok().build();
    }
    /**
     * NO SAVE OR DELETE
     * ITS AN ACTUAL PLACE
     */
}
