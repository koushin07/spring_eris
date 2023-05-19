package com.inventory.eris.database.seedings;

import com.inventory.eris.domain.administratives.role.Role;
import com.inventory.eris.domain.administratives.role.RoleDao;
import com.inventory.eris.domain.administratives.role.RoleType;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdministrativeSeeding implements CommandLineRunner {

    private final RoleDao roleDao;

    @Override
    public void run(String... args) throws Exception {
        if(!roleDao.findByRoleType(String.valueOf(RoleType.RDRRMC_REGION)).isPresent()){
            roleDao.saveRole(Role.builder().roleType(RoleType.RDRRMC_REGION).build());
            roleDao.saveRole(Role.builder().roleType(RoleType.RDRRMC_PROVINCE).build());
            roleDao.saveRole(Role.builder().roleType(RoleType.RDRRMC_MUNICIPALITY).build());
        }
        if()
    }
}
