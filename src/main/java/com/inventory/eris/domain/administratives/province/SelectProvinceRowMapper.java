package com.inventory.eris.domain.administratives.province;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectProvinceRowMapper implements RowMapper<Province> {
    @Override
    public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Province.builder()
                .provinceId( rs.getLong("province_id"))
                .provinceName(  rs.getString("province_name"))
                .createdAt( rs.getTimestamp("province_created_at").toLocalDateTime())
                .build();

    }
}
