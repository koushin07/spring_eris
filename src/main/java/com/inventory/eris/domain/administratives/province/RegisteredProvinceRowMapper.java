package com.inventory.eris.domain.administratives.province;

import com.inventory.eris.domain.administratives.province.Province;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class RegisteredProvinceRowMapper implements RowMapper<Province> {
    @Override
    public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Province.builder()
                .provinceId(rs.getLong("province_id"))
                .provinceName(rs.getString("province_name"))
                .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                .build();
    }
}
