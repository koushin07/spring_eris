package com.inventory.eris.domain.equipmentmanagement.equipmentowner;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEquipmentOwnerRowMapper implements RowMapper<EquipmentOwner> {
    @Override
    public EquipmentOwner mapRow(ResultSet rs, int rowNum) throws SQLException {
        return EquipmentOwner.builder()

                .build();
    }
}
