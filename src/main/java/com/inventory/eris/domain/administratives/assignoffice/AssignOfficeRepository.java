package com.inventory.eris.domain.administratives.assignoffice;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AssignOfficeRepository implements AssignOfficeDao {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public int saveAssign(AssignOffice assignOffice) {
        var sql = """
                INSERT INTO assign_offices(region_id, province_id, municipality_id)
                VALUES (?, ?, ?)
                """;
        return jdbcTemplate.update(sql,
                assignOffice.getRegion().getRegionId(),
                assignOffice.getProvince().getRegion().getRegionId(),
                assignOffice.getMunicipality().getMunicipalityId()
        );
    }

    @Override
    public Optional<AssignOffice> selectAssign(Long id) {
        var sql = """
                 SELECT
                     af.assign_office_id,
                     r.region_id, r.region_name, r.created_at as region_created_at,
                     prov.province_id, prov.province_name, prov.region_id, prov.created_at as province_created_at,
                     muni.municipality_id, muni.municipality_name, muni.latitude, muni.longitude, muni.province_id, muni.created_at as municipality_created_at,
                     af.created_at
                 FROM assign_offices af
                 JOIN regions r ON r.region_id = af.region_id
                 JOIN municipalities muni ON muni.municipality_id = af.municipality_id
                 JOIN provinces prov ON prov.province_id = af.province_id
                 WHERE af.assign_office_id = ?
                """;

        return jdbcTemplate.query(sql, new AssignOfficeRowMapper(), id).stream().findFirst();

    }

    @Override
    public Optional<AssignOffice> selectAssignByRegionId(Long regionId) {
        var sql = """
                 SELECT
                     af.assign_office_id,
                     r.region_id, r.region_name, r.created_at as region_created_at,
                     prov.province_id, prov.province_name, prov.region_id, prov.created_at as province_created_at,
                     muni.municipality_id, muni.municipality_name, muni.latitude, muni.longitude, muni.province_id, muni.created_at as municipality_created_at,
                     af.created_at
                 FROM assign_offices af
                 JOIN regions r ON r.region_id = af.region_id
                 JOIN municipalities muni ON muni.municipality_id = af.municipality_id
                 JOIN provinces prov ON prov.province_id = af.province_id
                 WHERE r.region_id = ?
                """;

        return jdbcTemplate.query(sql, new AssignOfficeRowMapper(), regionId).stream().findFirst();
    }

    @Override
    public Optional<AssignOffice> selectAssignByMunicipalityId(Long municipalityId) {

        var sql = """
                 SELECT
                     af.assign_office_id,
                     r.region_id, r.region_name, r.created_at as region_created_at,
                     prov.province_id, prov.province_name, prov.region_id, prov.created_at as province_created_at,
                     muni.municipality_id, muni.municipality_name, muni.latitude, muni.longitude, muni.province_id, muni.created_at as municipality_created_at,
                     af.created_at
                 FROM assign_offices af
                 JOIN regions r ON r.region_id = af.region_id
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
                     r.region_id, r.region_name, r.created_at as region_created_at,
                     prov.province_id, prov.province_name, prov.region_id, prov.created_at as province_created_at,
                     muni.municipality_id, muni.municipality_name, muni.latitude, muni.longitude, muni.province_id, muni.created_at as municipality_created_at,
                     af.created_at
                 FROM assign_offices af
                 JOIN regions r ON r.region_id = af.region_id
                 JOIN municipalities muni ON muni.municipality_id = af.municipality_id
                 JOIN provinces prov ON prov.province_id = af.province_id
                 WHERE prov.province_id = ?
                """;

        return jdbcTemplate.query(sql, new AssignOfficeRowMapper(), provinceId).stream().findFirst();
    }
}
