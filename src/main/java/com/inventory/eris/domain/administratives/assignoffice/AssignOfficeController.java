package com.inventory.eris.domain.administratives.assignoffice;


import com.inventory.eris.domain.administratives.province.Province;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/assign-offices")
public class AssignOfficeController {

    private final AssignOfficeService assignOfficeService;

    /**
     * All Registered province
     */
    @GetMapping
    public ResponseEntity<List<Province>> provinces(){

        return ok(assignOfficeService.selectAssignProvinceAll());
    }



}
