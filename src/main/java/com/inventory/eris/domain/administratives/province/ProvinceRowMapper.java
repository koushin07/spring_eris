package com.inventory.eris.domain.administratives.province;

import com.inventory.eris.domain.administratives.region.Region;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceRowMapper implements RowMapper<Province> {
    @Override
    public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Province(
          rs.getLong("province_id"),
          ProvinceEnum.valueOf(rs.getString("province_name")),
                Region.builder()
                        .regionId(rs.getLong("region_id"))
                        .regionName("region_name")
                        .createdAt(null)
                        .build(),
                rs.getTimestamp("created_at").toLocalDateTime()
          );

    }
}
