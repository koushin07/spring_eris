package com.inventory.eris.utils.validations.uniqueemail;

import com.inventory.eris.domain.administratives.office.OfficeDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final OfficeDao officeDao;


    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return officeDao.findByEmail(email).isEmpty();
    }
}
