package com.inventory.eris.domain.authentication;

import java.util.Optional;

import com.inventory.eris.domain.administratives.Personnel.Personnel;
import com.inventory.eris.domain.administratives.assignoffice.AssignOffice;
import com.inventory.eris.domain.administratives.assignoffice.AssignOfficeDao;
import com.inventory.eris.domain.administratives.office.OfficeDao;
import com.inventory.eris.domain.administratives.role.RoleDao;
import com.inventory.eris.domain.administratives.role.RoleType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventory.eris.Exception.EmailExistException;
import com.inventory.eris.Exception.ResourceNotFoundException;
import com.inventory.eris.Security.JWT.JwtService;
import com.inventory.eris.Security.JWT.blacklist.BlacklistService;
import com.inventory.eris.domain.administratives.office.Office;
import com.inventory.eris.domain.administratives.office.OfficeResponse;
import com.inventory.eris.domain.administratives.role.Role;
import com.inventory.eris.domain.administratives.role.RoleDaoImp;

import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.inventory.eris.domain.administratives.role.RoleType.RDRRMC_MUNICIPALITY;
import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.FALSE;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService {

        private final OfficeDao officeRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;
        private final RoleDaoImp roleDaoImp;
        private final UserDetailsService userDetailsService;
        private final BlacklistService blackListService;
        private final AssignOfficeDao assignOfficeDao;
        private final RoleDao roleDao;

        @Override
        public AuthenticationResponse register(RegisterRequest request) {

                /* checking if email exist */
                if (officeRepository.findByEmail(request.getEmail()).isPresent()) {
                        throw new EmailExistException("this email is already taken");
                }

                Optional<Role> role = roleDaoImp.findByRoleType(request.getRole().getRoleType().name());
                Office office = Office.builder()
                                .email(request.getEmail())
                                .contact(request.getContact())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(role.get())
                                .build();
                officeRepository.saveOffice(office);
                String jwtToken = jwtService.generateToken(office);

                return AuthenticationResponse.builder().AccessToken(jwtToken).build();
        }

        @Override
        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                log.info("authenticating.........");
                Office office = officeRepository.findByEmail(request.getEmail())
                                .orElseThrow(() -> new ResourceNotFoundException("username not found"));
                authenticationManager
                                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),
                                                request.getPassword()));

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
                Office office = officeRepository.findByEmail(request.getEmail())
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

        @Override
        public boolean ProvinceRegister(ProvinceRegistrationRequest request) {
                /* checking if email exist */
                if (officeRepository.findByEmail(request.getEmail()).isPresent()) {
                        throw new EmailExistException("this email is already taken");
                }

                return TRUE;

        }

        /**
         * TODO: check if email exist check and assign office MUNICIPALITY
         *
         * @param request
         * @return
         */
        @Override
        public boolean MunicipalityRegister(MunicipalityRegistrationRequest request) {
                /* checking if email exist */
                if (officeRepository.findByEmail(request.getEmail()).isPresent()) {
                        throw new EmailExistException("this email is already taken");
                }

                /*  check and assign office  */
                AssignOffice assignOffice = assignOfficeDao.selectAssignByMunicipalityId(request.getMunicipality().getMunicipalityId())
                        .orElseThrow(()-> new RuntimeException("this office is not found"));

                /*  check and assign role  */
                Role role = roleDao.findByRoleType(RDRRMC_MUNICIPALITY.name())
                        .orElseThrow(() -> new RuntimeException("this role type is not found"));

                Office municipality = Office.builder()
                        .contact(request.getContact())
                        .email(request.getEmail())
                        .assignOffice(assignOffice)
                        .role(role)
                        .build();
              int saved = officeRepository.saveOffice(municipality);
                if(saved == 0){
                        return false;
                }

                return true;

        }

}
