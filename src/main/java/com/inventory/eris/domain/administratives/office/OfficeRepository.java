package com.inventory.eris.domain.administratives.office;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
        var insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("offices").usingGeneratedKeyColumns("id");
        var parameters = new MapSqlParameterSource()
                .addValue("email", office.getEmail())
                .addValue("password", office.getPassword())
                .addValue("contact", office.getContact())
                .addValue("role_type", office.getRole().getRoleType().toString());
        var key = insert.executeAndReturnKey(parameters);
        office.setId(key.longValue());
        return office;
    }

    @Override
    public Optional<Office> selectoffice(Long id) {
        var sql = """
                SELECT o.* FROM offices o WHERE o.id = ?
                """;
        return jdbcTemplate.query(sql, new OfficeRowMapper(), id).stream().findFirst();
    }

    @Override
    public Office updateOffice(Long id, Office office) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Office> findByEmail(String email) {
        var sql = """
                SELECT * FROM offices WHERE offices.email = ?
                """;
        return jdbcTemplate.query(sql, new OfficeRowMapper(), email).stream().findFirst();
    }

}
