package com.inventory.eris.domain.equipmentmanagement.equipment;

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
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = TestConfig.class)
@Transactional
class EquipmentRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private EquipmentRepository underTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void selectEquipmentById() {
        Long id = 1L;
        var sql = """
                SELECT * FROM equipment WHERE equipment_id = ?
                """;
        SelectEquipmentRowMapper rowMapper = mock(SelectEquipmentRowMapper.class);
        when(jdbcTemplate.query(any(),any(SelectEquipmentRowMapper.class), eq(id)))
                .thenReturn(Collections.singletonList(mock(Equipment.class)));

        Optional<Equipment> result = underTest.selectEquipmentById(id);

        assertEquals(1, result.stream().count());
    }



    @Test
    void deleteEquipment() {
    }
}