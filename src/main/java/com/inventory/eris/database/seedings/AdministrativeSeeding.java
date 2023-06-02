package com.inventory.eris.database.seedings;

import com.inventory.eris.domain.administratives.municipality.Municipality;
import com.inventory.eris.domain.administratives.municipality.MunicipalityDao;
import com.inventory.eris.domain.administratives.province.Province;
import com.inventory.eris.domain.administratives.province.ProvinceDao;
import com.inventory.eris.domain.administratives.role.Role;
import com.inventory.eris.domain.administratives.role.RoleDao;
import com.inventory.eris.domain.administratives.role.RoleType;
import com.inventory.eris.utils.MunicipalityCoordinates;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
@Slf4j
public class AdministrativeSeeding implements CommandLineRunner {

    private final RoleDao roleDao;
    private final ProvinceDao provinceDao;
    private final MunicipalityDao municipalityDao;
    private final MunicipalityCoordinates coordinates;

    @Override
    public void run(String... args) throws Exception {

        if(roleDao.findByRoleType(String.valueOf(RoleType.RDRRMC_REGION)).isEmpty()){
            log.info("seeding data for role table");
            roleDao.saveRole(Role.builder().roleType(RoleType.valueOf(RoleType.RDRRMC_REGION.name())).build());
            roleDao.saveRole(Role.builder().roleType(RoleType.valueOf(RoleType.RDRRMC_PROVINCE.name())).build());
            roleDao.saveRole(Role.builder().roleType(RoleType.RDRRMC_MUNICIPALITY).build());
            log.info("done seeding for role table");
        }

        if(provinceDao.selectAllProvince().isEmpty()){
            Map<String, Map<String, double[]>> provinces = coordinates.coordinates();
            // Loop through the provinces
            provinces.forEach((province, municipalities) -> {
                Province pro = provinceDao.saveProvince(Province.builder().provinceName(province).build());
                municipalities.forEach((muni, coor)->{

                    Municipality municipality = municipalityDao.saveMunicipality(
                            Municipality.builder()
                                    .municipalityName(muni)
                                    .latitude(coor[0])
                                    .longitude(coor[1])
                                    .province(pro)
                                    .build());
                System.out.println(coor);
                System.out.println(muni);
            });

            });


//            System.out.println(mahinogs[0] + " " + mahinogs[1]);
        }





    }
}
