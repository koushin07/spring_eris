package com.inventory.eris.domain.administratives.assignoffice;

import com.inventory.eris.domain.administratives.municipality.Municipality;
import com.inventory.eris.domain.administratives.province.Province;
import com.inventory.eris.domain.administratives.province.ProvinceEnum;
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
                Province.builder()
                        .provinceId(rs.getLong("province_id"))
                        .provinceName(rs.getString("province_name"))
                        .createdAt(rs.getTimestamp("province_created_at").toLocalDateTime() != null
                                ? rs.getTimestamp("province_created_at").toLocalDateTime()
                                : null)
                        .build(),
                rs.getString("municipality_name").isEmpty() ? null : Municipality.builder()
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
