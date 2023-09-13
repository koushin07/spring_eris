package com.inventory.eris.Security.JWT.blacklist;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BlacklistRepository implements BlacklistDao {

    private final JdbcTemplate jdbcTemplate;

    public BlacklistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean isAccessTokenBlackListed(String accessToken) {
        var sql = """
                SELECT * FROM blacklists WHERE access_token = ?
                """;
        return !jdbcTemplate.query(sql, new BlacklistRowMapper(), accessToken).isEmpty();
    }

    @Override
    public Boolean isRefreshTokenBlackListed(String refreshToken) {
        var sql = """
                SELECT * FROM blacklists WHERE refresh_token = ?
                """;
        return !jdbcTemplate.query(sql, new BlacklistRowMapper(), refreshToken).isEmpty();
    }

    @Override
    public void blackListToken(String accessToken) {
        var sql = """
                INSERT INTO blacklists(access_token) VALUES(?)
                """;
        jdbcTemplate.update(sql, accessToken);
    }

    @Override
    public void blackListRefreshToken(String refreshToken, String accessToken) {
        var sql = """
                UPDATE blacklists SET refresh_token = ? WHERE access_token = ?
                """;
        jdbcTemplate.update(sql, refreshToken, accessToken);
    }

}
