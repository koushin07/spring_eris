package com.inventory.eris.domain.equipmentmanagement.equipmentattribute;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor

public class EquipmentAttributeRepository implements EquipmentAttributeDao {

    private static JdbcTemplate jdbcTemplate;

    @Override
    public EquipmentAttribute saveEquipmentAttribute(EquipmentAttribute attribute) {
        var sql = """
                INSERT INTO equipment_attributes(
                    serial_number, 
                    asset_description, 
                    code, 
                    model_number, 
                    unit, 
                    asset_id, 
                    category, 
                    remarks
                ) 
                VALUES(?,?,?,?,?,?,?,?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"equipment_attribute_id"});
            ps.setString(1, attribute.getSerialNumber());
            ps.setString(2, attribute.getAssetDescription());
            ps.setString(3, attribute.getCode());
            ps.setString(4, attribute.getModelNumber());
            ps.setString(5, attribute.getUnit());
            ps.setLong(6, attribute.getAssetId());
            ps.setString(7, String.valueOf(attribute.getCategory()));
            ps.setString(8, attribute.getRemark());
            return ps;
        }, keyHolder);
        Long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        attribute.setEquipmentAttributeId(id);
        return attribute;
    }

    @Override
    public Optional<EquipmentAttribute> selectEquipmentAttributeBySerialNumber(String serial) {

        var sql= """
                SELECT * FROM equipment_attributes WHERE serial_number = ?
                """;

        return jdbcTemplate.query(sql, new SelectEquipmentAttributeRowMapper(), serial).stream().findFirst();
    }
}
