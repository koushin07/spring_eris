package com.inventory.eris.domain.administratives.office;

import com.inventory.eris.domain.administratives.role.Role;
import com.inventory.eris.domain.administratives.role.RoleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJdbcTest
class OfficeRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private  OfficeRepository underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new OfficeRepository(jdbcTemplate);
    }

    @Test
    void saveOffice() {

        Office office = new Office();
        office.setEmail("example@example.com");
        office.setPassword("password");
        office.setContact("1234567890");
        office.setRole(new Role(RoleType.RDRRMC_MUNICIPALITY));

        var expectedSql = """
                INSERT INTO offices(email, password, contact, role_type) VALUES(?, ?, ?, ?)
                """ ;
        when(jdbcTemplate.update(eq(expectedSql), anyString(), anyString(), anyString(), anyString())).thenReturn(1);

        int result = underTest.saveOffice(office);

        verify(jdbcTemplate).update(eq(expectedSql), eq(office.getEmail()), eq(office.getPassword()),
                eq(office.getContact()), eq(office.getRole().getRoleType().toString()));
        assertEquals(1, result);
    }
}