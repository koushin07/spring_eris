package com.inventory.eris.domain.administratives.Personnel.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record CreatePersonnelRequest(

        Long OfficeId,
        @NotEmpty(message = "first name should not be empty")
        String firstName,
        @NotEmpty(message = "last name should not be empty")
        String lastName,
        String suffix,
        String middleName
){
}
