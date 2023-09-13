package com.inventory.eris.domain.administratives.Personnel;

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
public class PersonnelRepository implements  PersonnelDao {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public Personnel savePersonnel(Personnel personnel) {
        var sql = """
                INSERT INTO personnel( first_name, last_name, suffix, middle_name)
                VALUES (?, ?, ?, ?) 
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"personnel_id"});
            ps.setString(1, personnel.getFirstName());
            ps.setString(2, personnel.getLastName());
            ps.setString(3, personnel.getSuffix());
            ps.setString(4, personnel.getMiddleName());
            return  ps;
        }, keyHolder);
        Long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        personnel.setPersonnelId(id);
        return personnel;

    }

    @Override
    public Optional<Personnel> selectPersonnelById(Long id) {
       var sql = """
               SELECT * FROM personnel WHERE personnel_id = ?
               """;
       return jdbcTemplate.query(sql, new PersonnelRowMapper(), id).stream().findFirst();
    }

    @Override
    public List<Personnel> allPersonnel() {
        var sql = """
                SELECT * FROM PERSONNEL
                """;
        return jdbcTemplate.query(sql,new PersonnelRowMapper());
    }

    @Override
    public void updatePersonnel(Personnel personnel) {
        var sql = """
                UPDATE personnel
                SET 
                    first_name = ?, last_name = ?, suffix = ?, middle_name = ?, updated_at = ?
                WHERE personnel_id = ?
                """;
        jdbcTemplate.update(sql,
                personnel.getFirstName(),
                personnel.getLastName(),
                personnel.getSuffix(),
                personnel.getMiddleName(),
                LocalDateTime.now(),
                personnel.getPersonnelId()
        );
    }


}
