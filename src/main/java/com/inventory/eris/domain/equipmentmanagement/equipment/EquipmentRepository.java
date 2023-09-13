package com.inventory.eris.domain.equipmentmanagement.equipment;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EquipmentRepository implements EquipmentDao{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public Equipment saveEquipment(Equipment equipment) {
        var sql = """
                INSERT INTO equipment(equipment_name) VALUES(?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"equipment_id"});
            ps.setString(1,equipment.getEquipmentName());
            return ps;
        }, keyHolder);
        Long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        equipment.setEquipmentId(id);
        return equipment;
    }

    @Override
    public Optional<Equipment> selectEquipmentById(Long id) {
        var sql = """
                SELECT * FROM equipment WHERE equipment_id = ?
                """;
        return jdbcTemplate.query(sql, new SelectEquipmentRowMapper(), id).stream().findFirst();
    }

    @Override
    public List<Equipment> selectEquipment() {
        var sql= """
                SELECT * FROM equipment
                """;
        return jdbcTemplate.query(sql, new SelectEquipmentRowMapper());
    }

    @Override
    public void deleteEquipment(Long id) {

        var sql = """
                UPDATE equipment SET deleted_at = ? WHERE equipment_id = ?
                """;
        jdbcTemplate.update(sql, LocalDateTime.now(), id);
    }
}
