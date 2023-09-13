package com.inventory.eris.domain.administratives.officepersonnel;

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
public class OfficePersonnelRepository implements OfficePersonnelDao{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public OfficePersonnel saveOfficePersonnel(OfficePersonnel officePersonnel) {
        var sql = """
                INSERT INTO office_personnel(office_id, personnel_id)
                VALUES(?, ?)
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
         jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"office_personnel_id"});
            ps.setLong(1, officePersonnel.getOffice().getOfficeId());
            ps.setLong(2,officePersonnel.getPersonnel().getPersonnelId());

        return ps;
        }, keyHolder);
         Long id = keyHolder.getKey().longValue();
         officePersonnel.setOfficePersonnelId(id);
         return officePersonnel;
    }

    @Override
    public Optional<OfficePersonnel> selectOfficePersonnelById(Long id) {
        var sql = """
                SELECT
                    op.office_personnel_id,
                    op.created_at,
                    op.updated_at,
                    o.office_id,
                    o.role_id,
                    o.contact,
                    o.assign_office_id,
                    o.created_at as office_created_at,
                    o.updated_at as office_updated_at,
                    p.personnel_id,
                    p.first_name,
                    p.last_name,
                    p.suffix,
                    p.middle_name,
                    p.created_at as personnel_created_at,
                    p.updated_at as personnel_updated_at
                FROM office_personnel op
                JOIN offices o ON o.office_id = op.office_id
                JOIN personnel p ON p.personnel_id = op.personnel_id
                WHERE op.office_personnel_id = ?
                """;
        return jdbcTemplate.query(sql, new OfficePersonnelRowMapper(), id).stream().findFirst();
    }

    @Override
    public void deactivatePersonnel(Long id) {
        var sql = """
                UPDATE office_personnel SET is_active = 0 WHERE personnel_id = ?
                """;
        jdbcTemplate.update(sql, id);
    }
}
