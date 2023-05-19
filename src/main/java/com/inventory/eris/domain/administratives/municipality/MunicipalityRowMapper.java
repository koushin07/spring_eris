package com.inventory.eris.domain.administratives.municipality;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MunicipalityRowMapper implements RowMapper<Municipality> {
    @Override
    public Municipality mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Municipality(
                rs.getLong("municipality_id"),
                rs.getString("municipality_name"),
                rs.getDouble("latitude"),
                rs.getDouble("longitude"),
                rs.getLong("province_id")
        );
    }
}
