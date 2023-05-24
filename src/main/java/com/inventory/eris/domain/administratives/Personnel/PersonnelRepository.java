package com.inventory.eris.domain.administratives.Personnel;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PersonnelRepository implements  PersonnelDao {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public int savePersonnel(Personnel personnel) {
        var sql = """
                INSERT INTO personnel( first_name, last_name, suffix, middle_name)
                VALUES (?, ?, ?, ?) 
                """;
        return jdbcTemplate.update(sql,
                personnel.getFirstName(),
                personnel.getLastName(),
                personnel.getSuffix(),
                personnel.getMiddleName()
                );
    }

    @Override
    public Optional<Personnel> selectPersonnelById(Long id) {
       var sql = """
               SELECT * FROM personnel WHERE personnel_id = ?
               """;
       return jdbcTemplate.query(sql, new PersonnelRowMapper(), id).stream().findFirst();
    }
}
