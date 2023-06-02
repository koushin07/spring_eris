package com.inventory.eris.domain.administratives.assignoffice;

import com.inventory.eris.domain.administratives.province.Province;
import com.inventory.eris.domain.administratives.province.ProvinceRowMapper;
import com.inventory.eris.domain.administratives.province.RegisteredProvinceRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AssignOfficeRepository implements AssignOfficeDao {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public AssignOffice saveAssign(AssignOffice assignOffice) {
        var sql = """
                INSERT INTO assign_offices( province_id, municipality_id)
                VALUES (?, ?)
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"assign_office_id"});
            ps.setLong(1, assignOffice.getProvince().getProvinceId());
            ps.setLong(2, assignOffice.getMunicipality().getMunicipalityId());
            return ps;
        }, keyHolder);

        Long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        assignOffice.setAssignOfficeId(id);
      return assignOffice;
    }

    @Override
    public Optional<AssignOffice> selectAssign(Long id) {
        var sql = """
                 SELECT
                     af.assign_office_id,
                     prov.province_id, prov.province_name, prov.created_at as province_created_at,
                     muni.municipality_id, muni.municipality_name, muni.latitude, muni.longitude, muni.province_id, muni.created_at as municipality_created_at,
                     af.created_at
                 FROM assign_offices af
                 JOIN municipalities muni ON muni.municipality_id = af.municipality_id
                 JOIN provinces prov ON prov.province_id = af.province_id
                 WHERE af.assign_office_id = ?
                """;

        return jdbcTemplate.query(sql, new AssignOfficeRowMapper(), id).stream().findFirst();

    }



    @Override
    public Optional<AssignOffice> selectAssignByMunicipalityId(Long municipalityId) {

        var sql = """
                 SELECT
                     af.assign_office_id,
                     prov.province_id, prov.province_name, prov.created_at as province_created_at,
                     muni.municipality_id, muni.municipality_name, muni.latitude, muni.longitude, muni.province_id, muni.created_at as municipality_created_at,
                     af.created_at
                 FROM assign_offices af
                 JOIN municipalities muni ON muni.municipality_id = af.municipality_id
                 JOIN provinces prov ON prov.province_id = af.province_id
                 WHERE muni.municipality_id = ?
                """;

        return jdbcTemplate.query(sql, new AssignOfficeRowMapper(),municipalityId).stream().findFirst();
    }

    @Override
    public Optional<AssignOffice> selectAssignByProvinceId(Long provinceId) {

        var sql = """
                 SELECT
                     af.assign_office_id,
                     prov.province_id, prov.province_name, prov.created_at as province_created_at,
                     muni.municipality_id, muni.municipality_name, muni.latitude, muni.longitude, muni.province_id, muni.created_at as municipality_created_at,
                     af.created_at
                 FROM assign_offices af
                 JOIN municipalities muni ON muni.municipality_id = af.municipality_id
                 JOIN provinces prov ON prov.province_id = af.province_id
                 WHERE prov.province_id = ?
                """;

        return jdbcTemplate.query(sql, new AssignOfficeRowMapper(), provinceId).stream().findFirst();
    }

    @Override
    public List<Province> selectAssignProvinceAll() {
        var sql = """
                SELECT DISTINCT provinces.province_id, provinces.* FROM assign_offices JOIN provinces ON provinces.province_id = assign_offices.province_id
                """;
        return jdbcTemplate.query(sql, new RegisteredProvinceRowMapper());
    }
}
