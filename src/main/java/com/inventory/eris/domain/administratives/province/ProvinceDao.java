package com.inventory.eris.domain.administratives.province;

import java.util.List;
import java.util.Optional;

public interface ProvinceDao {
    Province saveProvince(Province province);
    Optional<Province> selectProvince(Long id);

    List<Province> selectAllProvince();
}
