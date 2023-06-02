package com.inventory.eris.domain.administratives.office;

import com.inventory.eris.domain.administratives.assignoffice.AssignOffice;
import com.inventory.eris.domain.administratives.role.Role;
import com.inventory.eris.domain.administratives.role.RoleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
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
        office.setAssignOffice(new AssignOffice());
        office.setRole(new Role());
        office.setEmail("example@gmail.com");
        office.setPassword("1234567");
        office.setContact("1234");

        // Mock the behavior of jdbcTemplate.update() to capture the KeyHolder argument
        KeyHolder keyHolder = new GeneratedKeyHolder();
        when(jdbcTemplate.update(any(PreparedStatementCreator.class), eq(keyHolder))).thenAnswer((Answer<Integer>) invocation -> {
            // Set a mock generated key value
            Map<String, Object> keyMap = new HashMap<>();
            keyMap.put("office_id", 1L);
            keyHolder.getKeyList().add(keyMap);
            return 1; // Return the number of affected rows
        });

        // Call the saveOffice() method
        Office result = underTest.saveOffice(office);

        // Verify that jdbcTemplate.update() was called with the expected SQL query and arguments
        verify(jdbcTemplate).update(any(PreparedStatementCreator.class), eq(keyHolder));

        // Verify that the generated key was properly set on the office object
        assertEquals(1L, result.getOfficeId());
    }
}