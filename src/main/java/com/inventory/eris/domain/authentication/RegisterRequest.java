package com.inventory.eris.domain.authentication;

import com.inventory.eris.domain.administratives.role.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotEmpty
    private String contact;
    @Email(message = "your email is invalid")
    private String email;
    @NotEmpty
    private String password;
    private String passwordConfirmation;
    private Role role;
}