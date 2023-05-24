package com.inventory.eris.domain.administratives.officepersonnel;

import com.inventory.eris.domain.administratives.Personnel.Personnel;
import com.inventory.eris.domain.administratives.office.Office;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfficePersonnelRowMapper implements RowMapper<OfficePersonnel> {
    @Override
    public OfficePersonnel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OfficePersonnel.builder()
                .officePersonnelId(rs.getLong("office_personnel_id"))
                .office(
                        Office.builder()
                                .officeId(rs.getLong("office_id"))
                                .role(null)
                                .email(rs.getString("email"))
                                .contact(rs.getString("contact"))
                                .password(null)
                                .assignOffice(null)
                                .createdAt(rs.getTimestamp("office_created_at").toLocalDateTime())
                                .updatedAt(rs.getTimestamp("office_updated_at").toLocalDateTime())
                                .build()
                )
                .personnel(
                        Personnel.builder()
                                .personnelId(rs.getLong("personnel_id"))
                                .firstName(rs.getString("first_name"))
                                .middleName(rs.getString("middle_name"))
                                .lastName(rs.getString("last_name"))
                                .suffix(rs.getString("suffix"))
                                .createdAt(rs.getTimestamp("personnel_created_at").toLocalDateTime())
                                .updatedAt(rs.getTimestamp("personnel_created_at").toLocalDateTime())
                                .build()
                )
                .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                .build();
    }
}
