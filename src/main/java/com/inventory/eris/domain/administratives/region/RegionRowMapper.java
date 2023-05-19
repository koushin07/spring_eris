package com.inventory.eris.domain.administratives.region;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionRowMapper implements RowMapper<Region> {
    @Override
    public Region mapRow(ResultSet result, int rowNum) throws SQLException {
        return new Region(
                result.getLong("region_id"),
                result.getString("region_name"),
                result.getTimestamp("created_at").toLocalDateTime() != null
                        ? result.getTimestamp("created_at").toLocalDateTime()
                        : null
                );
    }
}
