package com.inventory.eris.domain.administratives.province;

import com.inventory.eris.domain.administratives.municipality.Municipality;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceRowMapper implements RowMapper<Province> {
    @Override
    public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
        Province province = new Province(
                rs.getLong("province_id"),
                rs.getString("province_name"),
                null,
                rs.getTimestamp("province_created_at").toLocalDateTime()
        );

        if(rs.findColumn("municipality_id") != 0){
            List<Municipality> municipalities = new ArrayList<>();
            municipalities.add(new Municipality(
                    rs.getLong("municipality_id"),
                    rs.getString("municipality_name"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude"),
                    null
            ));

            province.setMunicipality(municipalities);
        }


        return province;
    }

}
