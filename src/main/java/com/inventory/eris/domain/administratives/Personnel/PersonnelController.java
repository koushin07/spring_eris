package com.inventory.eris.domain.administratives.Personnel;

import com.inventory.eris.domain.administratives.Personnel.requests.CreatePersonnelRequest;
import com.inventory.eris.domain.administratives.Personnel.requests.UpdatePersonnelRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/v1/personnel")
@RequiredArgsConstructor
public class PersonnelController {

    private final PersonnelService personnelService;


    @GetMapping
    public ResponseEntity<List<Personnel>> AllPersonnel(){
         return ok(personnelService.allPersonnel());
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> createPersonnel(@RequestBody @Valid CreatePersonnelRequest request,
                                                  @PathVariable("id") Long id){
        personnelService.savePersonnel(request, id);
        return ok("new personnel is created");
    }

    @PutMapping
    public ResponseEntity<Void> updatePersonnel(@RequestBody UpdatePersonnelRequest request){
        personnelService.updatePersonnel(request);
        return ok().build();
    }
}
