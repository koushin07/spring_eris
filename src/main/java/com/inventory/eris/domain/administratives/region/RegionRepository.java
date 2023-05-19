package com.inventory.eris.domain.administratives.region;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class RegionRepository implements RegionDao{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Region saveRegion(Region region) {
        var sql = """
                INSERT INTO regions (region_id, region_name) 
                VALUES (?, ?)                
                """;
        jdbcTemplate.update(sql, region.getRegionId(), region.getRegionName());
        return region;
    }

    @Override
    public Optional<Region> selectRegion(Long id) {
        var sql = """
                SELECT * FROM regions WHERE regions.id = ?
                """;
        return jdbcTemplate.query(sql, new RegionRowMapper(), id).stream().findFirst();
    }
}
