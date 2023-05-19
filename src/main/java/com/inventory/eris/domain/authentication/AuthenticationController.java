package com.inventory.eris.domain.authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.ResponseEntity.*;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    @Autowired
    private final AuthenticationService authenticationService;

    /**
     * @param request
     * @return status 200 authentication response
     * @Responsibility Register User
     */
    @PostMapping("/province-registration")
    public ResponseEntity<AuthenticationResponse> provinceRegistration(@RequestBody @Valid ProvinceRegistrationRequest request) {
        return ok(authenticationService.ProvinceRegister(request));
    }

    @PostMapping("/municipality-registration")
    public ResponseEntity<AuthenticationResponse> municipalityRegistration(@RequestBody @Valid MunicipalityRegistrationRequest request ){
        return ok(authenticationService.MunicipalityRegister(request));

    }


    @PostMapping
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        log.info("inside authenticate endpoint ");
        return ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refreshToken(@RequestBody AuthenticationRefreshTokenRequest request) {
        log.info("inside Refresh end point");
        return ok(authenticationService.refreshToken(request));
    }
}
