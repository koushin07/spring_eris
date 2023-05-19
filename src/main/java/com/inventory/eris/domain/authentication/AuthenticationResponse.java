package com.inventory.eris.domain.authentication;

import com.inventory.eris.domain.administratives.office.OfficeResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String AccessToken;

    private String refreshToken;

    private OfficeResponse OfficeResponse;
}
