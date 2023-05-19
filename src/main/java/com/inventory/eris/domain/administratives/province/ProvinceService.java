package com.inventory.eris.domain.administratives.province;

import java.util.Optional;

public interface ProvinceService {
    Province saveProvince(Province province);
    Optional<Province> selectProvince(Long id);
}
