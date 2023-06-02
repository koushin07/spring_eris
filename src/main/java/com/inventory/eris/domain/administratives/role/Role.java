package com.inventory.eris.domain.administratives.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//To use the @Data annotation you should add the Lombok dependency.
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Long roleId;
    private RoleType roleType;

}