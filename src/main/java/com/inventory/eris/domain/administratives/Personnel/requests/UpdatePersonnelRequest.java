package com.inventory.eris.domain.administratives.Personnel.requests;

import lombok.Builder;

@Builder
public record UpdatePersonnelRequest(
       Long PersonnelId,
        String firstName,
        String lastName,
        String suffix,
        String middleName
) {
}
