package com.inventory.eris.domain.equipmentmanagement.equipmentowner;

import com.inventory.eris.domain.administratives.office.Office;
import com.inventory.eris.domain.equipmentmanagement.equipment.Equipment;
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
public class EquipmentOwnerRepository implements EquipmentOwnerDao{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public EquipmentOwner saveEquipmentOwner(EquipmentOwner equipmentOwner) {
        var sql= """
                INSERT INTO equipment_owner (office_id, equipment_id, equipment_attribute_id)
                VALUES (?,?,?)
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql,new String[]{"equipment_owner_id"});
            ps.setLong(1, equipmentOwner.getOffice().getOfficeId());
            ps.setLong(2, equipmentOwner.getEquipment().getEquipmentId());
            ps.setLong(3, equipmentOwner.getEquipmentAttribute().getEquipmentAttributeId());
            return ps;
        }, keyHolder);
        Long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        equipmentOwner.setEquipmentOwnerId(id);

        return equipmentOwner;
    }

    @Override
    public Optional<EquipmentOwner> selectEquipmentOwnerById(Long id) {
        var sql= """
                SELECT * FROM equipment_owner
                WHERE equipment_owner_id = ?
                """;

        return jdbcTemplate.query(sql, new SelectEquipmentOwnerRowMapper(), id).stream().findFirst();
    }

    @Override
    public Optional<EquipmentOwner> selectEquipmentOwnerByOffice(Office office) {
       var sql = """
               SELECT* FROM equipment_owner WHERE office_id = ?
               """;
       return jdbcTemplate.query(sql,new SelectEquipmentOwnerRowMapper(),office.getOfficeId()).stream().findFirst();
    }

    @Override
    public Optional<EquipmentOwner> selectEquipmentOwnerByEquipmentId(Equipment equipment) {
        var sql = """
               SELECT* FROM equipment_owner WHERE equipment_id = ?
               """;
        return jdbcTemplate.query(sql,new SelectEquipmentOwnerRowMapper(),equipment.getEquipmentId()).stream().findFirst();

    }
}
