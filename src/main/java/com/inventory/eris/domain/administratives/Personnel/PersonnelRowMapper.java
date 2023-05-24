package com.inventory.eris.domain.administratives.Personnel;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonnelRowMapper implements RowMapper<Personnel> {
    @Override
    public Personnel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Personnel(
                rs.getLong("personnel_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("suffix"),
                rs.getString("middle_name"),
                rs.getTimestamp("created_at").toLocalDateTime() != null
                        ? rs.getTimestamp("created_at").toLocalDateTime()
                        : null,
                rs.getTimestamp("updated_at").toLocalDateTime() != null
                        ? rs.getTimestamp("updated_at").toLocalDateTime()
                        : null,
                rs.getTimestamp("deleted_at").toLocalDateTime() != null
                        ? rs.getTimestamp("deleted_at").toLocalDateTime()
                        : null
        );
    }
}
