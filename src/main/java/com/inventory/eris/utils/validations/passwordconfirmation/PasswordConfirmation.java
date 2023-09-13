package com.inventory.eris.utils.validations.passwordconfirmation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConfirmationValidator.class)
public @interface PasswordConfirmation {
    String[] value();
    String message() default "{PasswordConfirmation.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
