package com.inventory.eris.domain.authentication;

import com.inventory.eris.domain.administratives.Personnel.Personnel;
import com.inventory.eris.domain.administratives.province.ProvinceEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceRegistrationRequest {

    private Long province;
    @Email
    private String email;
    private Personnel personnel;
    @NotEmpty
    private String contact;
    @NotEmpty
    private String address;
    @NotEmpty
    private String password;
    @NotEmpty
    private String password_confirmation;

}
