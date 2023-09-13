package com.inventory.eris.domain.authentication.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRefreshTokenRequest {

    @NotEmpty(message = "Your email is empty to refresh a token")
    private String email;
    @NotEmpty(message = "please provide a refresh token")
    private String refreshToken;

    @NotEmpty(message = "your access token is missing")
    private String accessToken;
}
