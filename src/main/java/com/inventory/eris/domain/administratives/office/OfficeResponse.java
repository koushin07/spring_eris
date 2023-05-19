package com.inventory.eris.domain.administratives.office;

import com.inventory.eris.domain.administratives.role.Role;

import lombok.Builder;

@Builder
public record OfficeResponse(
        Long id,
        String email,
        String contact,
        Role role) {
}
