package com.inventory.eris.domain.administratives.province;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProvinceServiceImp implements ProvinceService{

    private final ProvinceDao provinceDao;

    @Override
    public Province saveProvince(Province province) {
        return null;
    }

    @Override
    public Optional<Province> selectProvince(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Province> selectAllProvince() {
        return provinceDao.selectAllProvince();
    }
}
