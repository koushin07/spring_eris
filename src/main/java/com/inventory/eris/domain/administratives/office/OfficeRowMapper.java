package com.inventory.eris.domain.administratives.office;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.inventory.eris.domain.administratives.role.Role;
import com.inventory.eris.domain.administratives.role.RoleType;

public class OfficeRowMapper implements RowMapper<Office> {

    @Override
    @Nullable
    public Office mapRow(ResultSet result, int i) throws SQLException {
        return new Office(result.getLong("id"),
                result.getString("email"),
                result.getString("password"),
                result.getString("contact"),
                new Role(RoleType.valueOf(result.getString("role_type"))),
                result.getTimestamp("created_at").toLocalDateTime() != null
                        ? result.getTimestamp("created_at").toLocalDateTime()
                        : null,
                result.getTimestamp("updated_at").toLocalDateTime() != null
                        ? result.getTimestamp("updated_at").toLocalDateTime()
                        : null,
                result.getTimestamp("deleted_at").toLocalDateTime() != null
                        ? result.getTimestamp("deleted_at").toLocalDateTime()
                        : null);
    }

}
