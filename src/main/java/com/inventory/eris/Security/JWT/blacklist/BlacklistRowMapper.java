package com.inventory.eris.Security.JWT.blacklist;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.micrometer.common.lang.Nullable;

public class BlacklistRowMapper implements RowMapper<Blacklist> {

    @Override
    @Nullable
    public Blacklist mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Blacklist(
                rs.getString("access_token"),
                rs.getString("refresh_token"),
                rs.getTimestamp("created_at").toLocalDateTime());
    }

}
