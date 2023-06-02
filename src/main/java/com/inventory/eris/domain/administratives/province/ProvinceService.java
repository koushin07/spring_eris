package com.inventory.eris.domain.administratives.province;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProvinceService {

    Province saveProvince(Province province);
    Optional<Province> selectProvince(Long id);

    List<Province> selectAllProvince();
}
