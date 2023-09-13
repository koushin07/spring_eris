package com.inventory.eris.domain.administratives.officepersonnel;


import com.inventory.eris.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;



@ContextConfiguration(classes = TestConfig.class)
@Transactional
class OfficePersonnelRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private OfficePersonnelRepository officePersonnelRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testSelectOfficePersonnelById() {
        // Mock data
        Long id = 1L;

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
        OfficePersonnelRowMapper rowMapper = mock(OfficePersonnelRowMapper.class);
        when(jdbcTemplate.query(any(), any(OfficePersonnelRowMapper.class), eq(id))).thenReturn(Collections.singletonList(mock(OfficePersonnel.class)));

        // Perform the select operation
        Optional<OfficePersonnel> result = officePersonnelRepository.selectOfficePersonnelById(id);

        assertEquals(1, result.stream().count());
    }

    @Test
    void testDeactivatePersonnel() {
        // Mock data
        Long id = 1L;

        var sql = """
                UPDATE office_personnel SET is_active = 0 WHERE personnel_id = ?
                """;
        when(jdbcTemplate.update(eq(sql), eq(id))).thenReturn(1);

        // Perform the deactivate operation
        officePersonnelRepository.deactivatePersonnel(id);

        // Verify the interactions
        verify(jdbcTemplate).update(eq(sql), eq(id));
    }
}
