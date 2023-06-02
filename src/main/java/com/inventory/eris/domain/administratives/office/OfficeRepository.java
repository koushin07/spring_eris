package com.inventory.eris.domain.administratives.office;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class OfficeRepository implements OfficeDao {

    private final JdbcTemplate jdbcTemplate;

    OfficeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Office> allOffice() {

        var sql = """
                    SELECT o.* FROM offices o WHERE o.deleted_at = null LIMIT 1000
                """;

        return jdbcTemplate.query(sql, new OfficeRowMapper());
    }

    @Override
    public void deleteOffice(Long id) {
        var sql = """
                DELETE FROM offices WHERE id = ?
                """;

        jdbcTemplate.update(sql, id);

    }

    @Override
    public Office saveOffice(Office office) {
            var sql = """
                    INSERT INTO offices(assign_office_id, role_id, email, password, contact) 
                    VALUES(?, ?, ?, ?, ?)
                    """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"office_id"});
            ps.setLong(1, office.getAssignOffice().getAssignOfficeId());
            ps.setLong(2, office.getRole().getRoleId());
            ps.setString(3, office.getEmail());
            ps.setString(4, office.getPassword());
            ps.setString(5, office.getContact());
            return ps;
        }, keyHolder);
            Long id = keyHolder.getKey().longValue();
            office.setOfficeId(id);
            return office;
        }

    @Override
    public Optional<Office> selectoffice(Long id) {
        var sql = """
                SELECT offices.*, roles.role_id, roles.role_type FROM offices JOIN roles ON roles.role_id = offices.role_id WHERE offices.office_id = ?
                """;
        return jdbcTemplate.query(sql, new OfficeRowMapper(), id).stream().findFirst();
    }

    @Override
    public void updateOffice( Office office) {
        var sql = """
                UPDATE offices
                SET 
                    email = ?, contact = ?, updated_at = ?
                WHERE office_id = ?
                """;
         jdbcTemplate.update(sql, office.getEmail(), office.getContact(), LocalDateTime.now(),office.getOfficeId());

    }

    @Override
    public Optional<Office> findByEmail(String email) {
        var sql = """
                SELECT offices.*, roles.role_id, roles.role_type FROM offices JOIN roles ON roles.role_id = offices.role_id WHERE offices.email = ?
                """;
        return jdbcTemplate.query(sql, new OfficeRowMapper(), email).stream().findFirst();
    }

}
