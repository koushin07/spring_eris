package com.inventory.eris.domain.administratives.municipality;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
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
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"municipality_id"});
            ps.setLong(1, municipality.getProvince().getProvinceId());
            ps.setString(2, municipality.getMunicipalityName());
            ps.setDouble(3, municipality.getLatitude());
            ps.setDouble(4, municipality.getLongitude());
            return ps;
        }, keyHolder);

        Long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        municipality.setMunicipalityId(id);
        return municipality;

    }

    @Override
    public Optional<Municipality> selectMunicipality(Long id) {
        var sql = """
                SELECT * FROM municipalities JOIN provinces ON provinces.province_id = municipalities.province_id WHERE municipality_id = ?
                """;
        return jdbcTemplate.query(sql,  new MunicipalityRowMapper(), id).stream().findFirst();
    }

    @Override
    public List<Municipality> selectAllMunicipality() {
        var sql = """
                SELECT * FROM municipalities JOIN provinces ON provinces.province_id = municipalities.province_id
                """;
        return jdbcTemplate.query(sql, new MunicipalityRowMapper());
    }

    @Override
    public void updateMunicipality(Long id, String rename) {
        var sql = """
                UPDATE municipalities SET municipality_name = ? , updated_at = ? WHERE id = ?
                """;
        jdbcTemplate.update(sql, rename, LocalDateTime.now(), id);
    }
    



}
