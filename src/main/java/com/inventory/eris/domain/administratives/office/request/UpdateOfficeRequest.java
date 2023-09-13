package com.inventory.eris.domain.administratives.office.request;

import lombok.Builder;

@Builder
public record UpdateOfficeRequest(
        String email,
        String contact
) {
}
