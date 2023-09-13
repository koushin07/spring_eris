package com.inventory.eris.domain.authentication;

import java.util.Optional;

import com.inventory.eris.domain.administratives.Personnel.Personnel;
import com.inventory.eris.domain.administratives.Personnel.PersonnelDao;
import com.inventory.eris.domain.administratives.assignoffice.AssignOffice;
import com.inventory.eris.domain.administratives.assignoffice.AssignOfficeDao;
import com.inventory.eris.domain.administratives.municipality.Municipality;
import com.inventory.eris.domain.administratives.municipality.MunicipalityDao;
import com.inventory.eris.domain.administratives.office.OfficeDao;
import com.inventory.eris.domain.administratives.officepersonnel.OfficePersonnel;
import com.inventory.eris.domain.administratives.officepersonnel.OfficePersonnelDao;
import com.inventory.eris.domain.administratives.province.Province;
import com.inventory.eris.domain.administratives.province.ProvinceDao;
import com.inventory.eris.domain.administratives.role.RoleDao;
import com.inventory.eris.domain.authentication.request.AuthenticationRefreshTokenRequest;
import com.inventory.eris.domain.authentication.request.AuthenticationRequest;
import com.inventory.eris.domain.authentication.request.MunicipalityRegistrationRequest;
import com.inventory.eris.domain.authentication.request.ProvinceRegistrationRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventory.eris.utils.Exception.EmailExistException;
import com.inventory.eris.utils.Exception.ResourceNotFoundException;
import com.inventory.eris.Security.JWT.JwtService;
import com.inventory.eris.Security.JWT.blacklist.BlacklistService;
import com.inventory.eris.domain.administratives.office.Office;
import com.inventory.eris.domain.administratives.office.response.OfficeResponse;
import com.inventory.eris.domain.administratives.role.Role;

import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import static com.inventory.eris.domain.administratives.role.RoleType.RDRRMC_MUNICIPALITY;
import static com.inventory.eris.domain.administratives.role.RoleType.RDRRMC_PROVINCE;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService {

        private final OfficeDao officeDao;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;
        private final UserDetailsService userDetailsService;
        private final BlacklistService blackListService;
        private final AssignOfficeDao assignOfficeDao;
        private final RoleDao roleDao;
        private final MunicipalityDao municipalityDao;
        private final ProvinceDao provinceDao;
        private final PersonnelDao personnelDao;
        private final OfficePersonnelDao officePersonnelDao;



        @Override
        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                log.info("authenticating.........");
                Office office = officeDao.findByEmail(request.getEmail())
                                .orElseThrow(() -> new ResourceNotFoundException("username not found"));
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );

                log.info("authenticated user " + office.getEmail());
                OfficeResponse response = OfficeResponse.builder()
                                .contact(office.getContact())
                                .email(office.getEmail())
                                .id(office.getOfficeId())
                                .role(office.getRole())
                                .build();
                String jwtToken = jwtService.generateToken(office);
                String refresher = jwtService.generateRefreshToken(office);
                log.info("this is the refresher " + refresher);
                return AuthenticationResponse.builder()
                                .AccessToken(jwtToken)
                                .refreshToken(refresher)
                                .OfficeResponse(response).build();


        }

        @Override
        public AuthenticationResponse refreshToken(AuthenticationRefreshTokenRequest request) {
                blackListService.blackListToken(request.getAccessToken());

                log.info("request value is \n " + request);
                Office office = officeDao.findByEmail(request.getEmail())
                                .orElseThrow(() -> new ResourceNotFoundException("office is not found"));
                UserDetails userDetails = userDetailsService.loadUserByUsername(office.getUsername());
                log.info(userDetails.getUsername());
                if (!jwtService.isRefreshTokenValid(request.getRefreshToken(), userDetails)) {
                        throw new JwtException("access token not valid");
                }

                log.info("generating refresh token for user " + office.getEmail());
                OfficeResponse response = OfficeResponse.builder()
                                .contact(office.getContact())
                                .email(office.getEmail())
                                .id(office.getOfficeId())
                                .role(office.getRole())
                                .build();
                return AuthenticationResponse.builder()
                                .OfficeResponse(response)
                                .refreshToken(jwtService.generateRefreshToken(userDetails))
                                .AccessToken(jwtService.generateToken(userDetails))
                                .build();
        }

        /**
         *
         * @param request
         * @return void
         *
         */
        @Override
        @Transactional
        public void ProvinceRegister(ProvinceRegistrationRequest request) {
                /* checking if email exist */
                if (officeDao.findByEmail(request.getEmail()).isPresent()) {
                        throw new EmailExistException("this email is already taken");
                }

                Optional<AssignOffice> assignOffice = assignOfficeDao.selectAssignByProvinceId(request.getProvince());

                if(!assignOffice.isEmpty()){
                        throw new ResourceNotFoundException("Office is already Taken");
                }

                Province province = provinceDao.selectProvince(request.getProvince())
                        .orElseThrow(()-> new ResourceNotFoundException("province not found"));

                AssignOffice assigningOffice = assignOfficeDao.assignProvince(AssignOffice.builder()
                        .province(province)
                        .build());

                Role role = roleDao.findByRoleType(RDRRMC_PROVINCE.name())
                        .orElseThrow(() -> new ResourceNotFoundException("this role type is not found"));

                Personnel personnel = personnelDao.savePersonnel(request.getPersonnel());

                Office office = Office.builder()
                        .contact(request.getContact())
                        .email(request.getEmail())
                        .assignOffice(assigningOffice)
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(role)
                        .build();



                Office saved = officeDao.saveOffice(office);
                OfficePersonnel officePersonnel = officePersonnelDao.saveOfficePersonnel(OfficePersonnel.builder()
                        .personnel(personnel)
                        .office(saved)
                        .build());

        }

        /**
         *
         * @param request
         * @return void
         */
        @Override
        @Transactional
        public void MunicipalityRegister(MunicipalityRegistrationRequest request) {
                /* checking if email exist */
                if (officeDao.findByEmail(request.getEmail()).isPresent()) {
                        throw new EmailExistException("this email is already taken");
                }

                /*  check and assign office  */
                Optional<AssignOffice> assignOffice = assignOfficeDao.selectAssignByMunicipalityId(request.getMunicipality());

                if(!assignOffice.isEmpty()){
                        throw new RuntimeException("office is already taken");
                }

                Municipality municipality  = municipalityDao.selectMunicipality(request.getMunicipality())
                        .orElseThrow(()-> new RuntimeException("municipality not found"));


                AssignOffice assigningOffice = assignOfficeDao.assignMunicipality(AssignOffice.builder()
                                .municipality(municipality)
                                .province(municipality.getProvince())
                        .build());
                Personnel personnel = personnelDao.savePersonnel(request.getPersonnel());

                /*  check and assign role  */
                Role role = roleDao.findByRoleType(RDRRMC_MUNICIPALITY.name())
                        .orElseThrow(() -> new RuntimeException("this role type is not found"));

                System.out.println(assigningOffice.getAssignOfficeId());
                Office office = Office.builder()
                        .contact(request.getContact())
                        .email(request.getEmail())
                        .assignOffice(assigningOffice)
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(role)
                        .build();



              Office saved = officeDao.saveOffice(office);

                OfficePersonnel officePersonnel = officePersonnelDao.saveOfficePersonnel(OfficePersonnel.builder()
                        .personnel(personnel)
                        .office(saved)
                        .build());
        }

}
