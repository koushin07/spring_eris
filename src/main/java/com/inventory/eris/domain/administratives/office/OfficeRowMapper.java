package com.inventory.eris.domain.administratives.office;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.inventory.eris.domain.administratives.assignoffice.AssignOffice;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.inventory.eris.domain.administratives.role.Role;
import com.inventory.eris.domain.administratives.role.RoleType;

public class OfficeRowMapper implements RowMapper<Office> {

    @Override
    @Nullable
    public Office mapRow(ResultSet result, int i) throws SQLException {
        return new Office(result.getLong("office_id"),
                result.getString("email"),
                result.getString("password"),
                result.getString("contact"),
                AssignOffice.builder()
                        .assignOfficeId(result.getLong("assign_office_id"))
                        .build(),
                new Role(result.getLong("role_id"),RoleType.valueOf(result.getString("role_type"))),
                result.getTimestamp("created_at").toLocalDateTime() != null
                        ? result.getTimestamp("created_at").toLocalDateTime()
                        : null,
                result.getTimestamp("updated_at").toLocalDateTime() != null
                        ? result.getTimestamp("updated_at").toLocalDateTime()
                        : null);
    }

}
