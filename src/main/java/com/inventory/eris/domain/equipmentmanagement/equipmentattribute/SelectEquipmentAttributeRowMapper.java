package com.inventory.eris.domain.equipmentmanagement.equipmentattribute;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEquipmentAttributeRowMapper implements RowMapper<EquipmentAttribute> {
    @Override
    public EquipmentAttribute mapRow(ResultSet rs, int rowNum) throws SQLException {
        return EquipmentAttribute.builder()
                .equipmentAttributeId(rs.getLong("equipment_attribute_id"))
                .serialNumber(rs.getString("serial_number"))
                .assetDescription(rs.getString("asset_description"))
                .code(rs.getString("code"))
                .modelNumber(rs.getString("model_number"))
                .unit(rs.getString("unit"))
                .assetId(rs.getInt("asset_id"))
                .category(EquipmentCategory.valueOf(rs.getString("category")))
                .remark(rs.getString("remarks"))
                .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                .build();
    }
}
