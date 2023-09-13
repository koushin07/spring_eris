package com.inventory.eris.domain.administratives.office;

import java.util.List;
import java.util.Optional;

import com.inventory.eris.Security.JWT.JwtService;
import com.inventory.eris.domain.administratives.assignoffice.AssignOffice;
import com.inventory.eris.domain.administratives.assignoffice.AssignOfficeDao;
import com.inventory.eris.domain.administratives.municipality.Municipality;
import com.inventory.eris.domain.administratives.municipality.MunicipalityDao;
import com.inventory.eris.domain.administratives.office.request.ChangePasswordRequest;
import com.inventory.eris.domain.administratives.office.request.UpdateOfficeRequest;
import com.inventory.eris.domain.administratives.office.response.OfficeResponse;
import com.inventory.eris.domain.administratives.office.response.UpdateOfficeResponse;
import com.inventory.eris.utils.Exception.PasswordConfirmationException;
import com.inventory.eris.utils.Exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfficeServiceImp implements OfficeService {

    private final OfficeDao officeDao;
    private final MunicipalityDao municipalityDao;
    private final AssignOfficeDao assignOfficeDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public Office saveOffice(Office office) {
        return officeDao.saveOffice(office);
    }

    public List<Office> allOffices() {
        return officeDao.allOffice();
    }

    public Optional<Office> selectOffice(Long id) {
        return officeDao.selectoffice(id);
    }

    @Override
    public UpdateOfficeResponse updateOffice(Long id, UpdateOfficeRequest request) {
       Office existingOffice = selectOffice(id).orElseThrow(()-> new RuntimeException("office doesn't exist to update"));

       existingOffice.setEmail(request.email());
       existingOffice.setContact(request.contact());
       officeDao.updateOffice(existingOffice);
       return UpdateOfficeResponse.builder()
               .accessToken(jwtService.generateToken(existingOffice))
               .refreshToken(jwtService.generateRefreshToken(existingOffice))
               .office( OfficeResponse.builder()
                       .contact(existingOffice.getContact())
                       .email(existingOffice.getEmail())
                       .role(existingOffice.getRole())
                       .build())
               .build();
    }

    @Override
    public void changePassword(ChangePasswordRequest changePasswordRequest) {

        Office office = officeDao.selectoffice(changePasswordRequest.officeId())
                .orElseThrow(()-> new ResourceNotFoundException("not found"));

        if(!changePasswordRequest.confirmPassword().equals(changePasswordRequest.newPassword())){
            throw new PasswordConfirmationException("password doesn't match");
        }

        if(!passwordEncoder.matches(changePasswordRequest.oldPassword(), office.getPassword())){
            throw new PasswordConfirmationException("old password doesn't match");
        }
        office.setPassword(changePasswordRequest.newPassword());


        officeDao.changePassword(changePasswordRequest.officeId(), passwordEncoder.encode(changePasswordRequest.newPassword()));
    }

    @Override
    public void reassignMunicipality(Long id, Long municipalityId) {

        AssignOffice assignOffice = assignOfficeDao.selectAssignByMunicipalityId(municipalityId)
                .orElseThrow(()-> new ResourceNotFoundException("municipality not found"));
        officeDao.reassignMunicipality(id, assignOffice.getAssignOfficeId());
    }

}
