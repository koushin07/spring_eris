package com.inventory.eris.domain.equipmentmanagement.equipment;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEquipmentRowMapper implements RowMapper<Equipment> {
    @Override
    public Equipment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Equipment.builder()
                .equipmentId(rs.getLong("equipment_id"))
                .equipmentName(rs.getString("equipment_name"))
                .build();
    }
}
