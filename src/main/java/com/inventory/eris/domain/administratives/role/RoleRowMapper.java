package com.inventory.eris.domain.administratives.role;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    @Nullable
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Role(RoleType.valueOf(rs.getString("role_type")));
    }

}
