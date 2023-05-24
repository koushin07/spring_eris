package com.inventory.eris.database.seedings;

import com.inventory.eris.domain.administratives.region.Region;
import com.inventory.eris.domain.administratives.region.RegionDao;
import com.inventory.eris.domain.administratives.role.Role;
import com.inventory.eris.domain.administratives.role.RoleDao;
import com.inventory.eris.domain.administratives.role.RoleType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
@Slf4j
public class AdministrativeSeeding implements CommandLineRunner {

    private final RoleDao roleDao;
    private final RegionDao regionDao;
    @Override
    public void run(String... args) throws Exception {

        if(!roleDao.findByRoleType(String.valueOf(RoleType.RDRRMC_REGION)).isPresent()){
            log.info("seeding data for role table");
            roleDao.saveRole(Role.builder().roleType(RoleType.valueOf(RoleType.RDRRMC_REGION.name())).build());
            roleDao.saveRole(Role.builder().roleType(RoleType.valueOf(RoleType.RDRRMC_PROVINCE.name())).build());
            roleDao.saveRole(Role.builder().roleType(RoleType.RDRRMC_MUNICIPALITY).build());
            log.info("done seeding for role table");
        }

        if(regionDao.selectAllRegion().isEmpty()){
            log.info("seeding regions");
            Region ilocos = regionDao.saveRegion(Region.builder().regionId(1L).regionName("Ilocos Region").build());

            regionDao.saveRegion(Region.builder().regionId(2L).regionName("Cagayan Valley").build());
            regionDao.saveRegion(Region.builder().regionId(3L).regionName("Central Luzon").build());
            regionDao.saveRegion(Region.builder().regionId(4L).regionName("CALABARZON").build());
            Region bicol = regionDao.saveRegion(Region.builder().regionId(5L).regionName("Bicol Region").build());

            regionDao.saveRegion(Region.builder().regionId(6L).regionName("Western Visayas").build());
            regionDao.saveRegion(Region.builder().regionId(7L).regionName("Central Visayas").build());
            regionDao.saveRegion(Region.builder().regionId(8L).regionName("MIMAROPA Region").build());
            log.info("done seeding regions");

        }






    }
}
