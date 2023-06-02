package com.inventory.eris.domain.authentication;

public interface AuthenticationService {


    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse refreshToken(AuthenticationRefreshTokenRequest request);

    void ProvinceRegister(ProvinceRegistrationRequest request);

    void MunicipalityRegister(MunicipalityRegistrationRequest request);

}
