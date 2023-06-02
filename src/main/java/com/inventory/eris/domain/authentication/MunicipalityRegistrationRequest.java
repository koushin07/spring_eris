package com.inventory.eris.domain.authentication;

import com.inventory.eris.domain.administratives.Personnel.Personnel;
import com.inventory.eris.domain.administratives.municipality.Municipality;
import com.inventory.eris.domain.administratives.province.Province;
import com.inventory.eris.domain.administratives.province.ProvinceEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MunicipalityRegistrationRequest {


    private Long municipality;
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

