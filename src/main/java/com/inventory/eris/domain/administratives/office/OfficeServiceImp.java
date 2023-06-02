package com.inventory.eris.domain.administratives.office;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

import com.inventory.eris.utils.Exception.PasswordConfirmationException;
import com.inventory.eris.utils.Exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfficeServiceImp implements OfficeService {

    private final OfficeDao officeDao;
    private final PasswordEncoder passwordEncoder;

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
    public Office updateOffice(Long id, Office office) {
       Office existingOffice = selectOffice(id).orElseThrow(()-> new RuntimeException("office doesn't exist to update"));

       existingOffice.setEmail(office.getEmail());
       existingOffice.setContact(office.getContact());
         officeDao.updateOffice( existingOffice);
         return existingOffice;
    }

    @Override
    public void changePassword(ChangePasswordRequest changePasswordRequest) {

        Office office = officeDao.selectoffice(changePasswordRequest.officeId()).orElseThrow(()-> new ResourceNotFoundException("not found"));
        if(!changePasswordRequest.confirmPassword().equals(changePasswordRequest.newPassword())){
            throw new PasswordConfirmationException("reconfirm password");
        }

        if(!passwordEncoder.matches(changePasswordRequest.oldPassword(), office.getPassword())){
            throw new PasswordConfirmationException("password does not match");
        }
        office.setPassword(changePasswordRequest.newPassword());


    }

}
