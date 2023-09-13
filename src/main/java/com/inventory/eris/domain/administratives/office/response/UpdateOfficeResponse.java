package com.inventory.eris.domain.administratives.office.response;

import lombok.Builder;

@Builder
public record UpdateOfficeResponse(
        String accessToken,
        String refreshToken,
        OfficeResponse office
) {
}
