package com.inventory.eris.domain.administratives.region;

import java.util.Optional;

public interface RegionDao {
    Region saveRegion(Region region);
    Optional<Region> selectRegion(Long id);
}
