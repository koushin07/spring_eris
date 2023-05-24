package com.inventory.eris.domain.administratives.region;

import java.util.List;
import java.util.Optional;

public interface RegionDao {
    Region saveRegion(Region region);
    Optional<Region> selectRegion(Long id);
    List<Region> selectAllRegion();
}
