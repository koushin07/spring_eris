package com.inventory.eris.domain.administratives.municipality;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MunicipalityRepository implements MunicipalityDao{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public Municipality saveMunicipality(Municipality municipality) {
        var sql = """
                INSERT INTO municipalities(province_id, municipality_name, latitude, longitude)
                VALUES(?, ?, ?, ?)
                """;
        jdbcTemplate.update(sql,
                municipality.getProvinceId(),
                municipality.getMunicipalityName(),
                municipality.getLatitude(),
                municipality.getLatitude()
        );
        return municipality;

    }

    @Override
    public Optional<Municipality> selectMunicipality(Long id) {
        var sql = """
                SELECT * FROM municipalities WHERE municipality_id = ?
                """;
        return jdbcTemplate.query(sql,  new MunicipalityRowMapper(), id).stream().findFirst();
    }
}
