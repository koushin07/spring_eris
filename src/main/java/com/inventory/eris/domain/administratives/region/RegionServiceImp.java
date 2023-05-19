package com.inventory.eris.domain.administratives.region;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionServiceImp  implements  RegionService{

    private  final RegionDao regionDao;
    @Override
    public Region saveRegion(Region region) {
        return regionDao.saveRegion(region);
    }

    @Override
    public Optional<Region> selectRegion(Long id) {
        return regionDao.selectRegion(id);
    }
}
