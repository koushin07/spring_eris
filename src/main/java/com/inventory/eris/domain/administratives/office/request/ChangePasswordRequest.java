package com.inventory.eris.domain.administratives.office.request;

import com.inventory.eris.utils.validations.passwordconfirmation.PasswordConfirmation;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record ChangePasswordRequest(

                Long officeId,
                @NotEmpty(message = "please provide new password")
                String newPassword,
                @NotEmpty(message = "password confirmation is empty")
                String confirmPassword,
                @NotEmpty(message = "Old password must not be empty")
                String oldPassword) {
}
