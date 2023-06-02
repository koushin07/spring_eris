package com.inventory.eris.domain.administratives.province;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/provinces")
public class ProvinceController {

    private final ProvinceService provinceService;


    @GetMapping
    public ResponseEntity<List<Province>> provinces(){

        return ok(provinceService.selectAllProvince());
    }
}
