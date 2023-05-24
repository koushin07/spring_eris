package com.inventory.eris.domain.administratives.province;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProvinceRepository implements ProvinceDao{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public Province saveProvince(Province province) {
        var insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("offices").usingGeneratedKeyColumns("id");
        var parameters = new MapSqlParameterSource()
                .addValue("province_name", province.getProvinceName())
                .addValue("region_id", province.getRegion().getRegionId());
        var key = insert.executeAndReturnKey(parameters);
        province.setProvinceId(key.longValue());
        return province;
    }

    @Override
    public Optional<Province> selectProvince(Long id) {
        var sql = """
                SELECT * FROM provinces JOIN regions ON regions.region_id = provinces.region_id WHERE provinces.id = ? 
                """;
        return jdbcTemplate.query(sql, new ProvinceRowMapper(), id).stream().findFirst();
    }
}
