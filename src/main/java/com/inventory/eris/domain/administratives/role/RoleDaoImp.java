package com.inventory.eris.domain.administratives.role;

import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImp implements RoleDao {

    private final JdbcTemplate jdbcTemplate;

    public RoleDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Role saveRole(Role role) {
        var sql = """
                INSERT INTO roles(role_type) VALUES(?)
                """;
        jdbcTemplate.update(sql, role.getRoleType().name());
        return role;
    }

    @Override
    public Optional<Role> findByRoleType(String role_type) {
        var sql = """
                SELECT * FROM roles WHERE roles.role_type = ?
                """;
        return jdbcTemplate.query(sql, new RoleRowMapper(), role_type).stream().findFirst();
    }

}
