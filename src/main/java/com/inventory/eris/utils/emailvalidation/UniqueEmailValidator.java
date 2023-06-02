package com.inventory.eris.utils.emailvalidation;

import com.inventory.eris.domain.administratives.office.Office;
import com.inventory.eris.domain.administratives.office.OfficeDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final OfficeDao officeDao;


    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return officeDao.findByEmail(email).isPresent();
    }
}
