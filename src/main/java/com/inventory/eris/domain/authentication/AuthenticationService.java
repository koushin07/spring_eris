package com.inventory.eris.domain.authentication;

import com.inventory.eris.domain.authentication.request.AuthenticationRefreshTokenRequest;
import com.inventory.eris.domain.authentication.request.AuthenticationRequest;
import com.inventory.eris.domain.authentication.request.MunicipalityRegistrationRequest;
import com.inventory.eris.domain.authentication.request.ProvinceRegistrationRequest;

public interface AuthenticationService {


    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse refreshToken(AuthenticationRefreshTokenRequest request);

    void ProvinceRegister(ProvinceRegistrationRequest request);

    void MunicipalityRegister(MunicipalityRegistrationRequest request);

}
