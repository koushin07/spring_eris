package com.inventory.eris.domain.administratives.assignoffice;

import com.inventory.eris.domain.administratives.municipality.Municipality;
import com.inventory.eris.domain.administratives.province.Province;
import com.inventory.eris.domain.administratives.province.ProvinceEnum;
import com.inventory.eris.domain.administratives.region.Region;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignOfficeRowMapper implements RowMapper<AssignOffice> {
    @Override
    public AssignOffice mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AssignOffice(
                rs.getLong("assign_office_id"),
                Region.builder()
                        .regionId(rs.getLong("region_id"))
                        .regionName(rs.getString("region_name"))
                        .createdAt(rs.getTimestamp("region_created_at").toLocalDateTime() != null
                            ? rs.getTimestamp("region_created_at").toLocalDateTime()
                            : null)
                        .build(),
                Province.builder()
                        .provinceId(rs.getLong("province_id"))
                        .provinceName(ProvinceEnum.valueOf(rs.getString("province_name")))
                        .region(null)
                        .createdAt(rs.getTimestamp("province_created_at").toLocalDateTime() != null
                                ? rs.getTimestamp("province_created_at").toLocalDateTime()
                                : null)
                        .build(),
                Municipality.builder()
                        .municipalityId(rs.getLong("municipality_id"))
                        .municipalityName(rs.getString("municipality_name"))
                        .province(null)
                        .latitude(rs.getDouble("latitude"))
                        .longitude(rs.getDouble("longitude"))
                        .build(),
                rs.getTimestamp("created_at").toLocalDateTime() != null
                        ? rs.getTimestamp("created_at").toLocalDateTime()
                        : null
        );
    }
}
