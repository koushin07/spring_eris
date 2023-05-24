package com.inventory.eris.domain.authentication;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse refreshToken(AuthenticationRefreshTokenRequest request);

    boolean ProvinceRegister(ProvinceRegistrationRequest request);

    boolean MunicipalityRegister(MunicipalityRegistrationRequest request);

}
