package com.inventory.eris.domain.administratives.office;

import com.inventory.eris.domain.administratives.Personnel.requests.CreatePersonnelRequest;
import com.inventory.eris.domain.administratives.office.request.ChangePasswordRequest;
import com.inventory.eris.domain.administratives.office.request.UpdateOfficeRequest;
import com.inventory.eris.domain.administratives.office.response.OfficeResponse;
import com.inventory.eris.domain.administratives.office.response.UpdateOfficeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
        return ok("Office is Created");
    }

    @PutMapping("")
    public ResponseEntity<UpdateOfficeResponse> update(@AuthenticationPrincipal(expression = "officeId") Long id, @RequestBody UpdateOfficeRequest request){
        System.out.println(id);
       return ok(officeService.updateOffice(id, request));
    }

    @PutMapping("/change-password")
    public ResponseEntity<Void> password(@RequestBody @Valid ChangePasswordRequest newPassword){
        officeService.changePassword(newPassword);
        return ok().build();
    }

    @PutMapping("/{municipalityId}")
    public ResponseEntity<Void> reassignMunicipality(@AuthenticationPrincipal(expression = "officeId") Long id,
                                                     @PathVariable("municipalityId") Long municipalityId){

        officeService.reassignMunicipality(id, municipalityId);
        return ok().build();
    }



}
