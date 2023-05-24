package com.inventory.eris.domain.authentication;

import com.inventory.eris.Exception.EmailExistException;
import com.inventory.eris.domain.administratives.municipality.MunicipalityService;
import com.inventory.eris.domain.administratives.office.Office;
import com.inventory.eris.domain.administratives.office.OfficeRepository;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


class AuthenticationServiceImpTest {

    @Autowired
    private Flyway flyway;

    @Mock
    private OfficeRepository officeRepository;

    @InjectMocks
    private AuthenticationServiceImp underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void ShouldRegisterMunicipality() {
        // Arrange
        MunicipalityRegistrationRequest request = new MunicipalityRegistrationRequest();
        request.setContact("John Doe");
        request.setEmail("john.doe@example.com");

        when(officeRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(officeRepository.saveOffice(any(Office.class))).thenReturn(1);

        // Act
        boolean result = underTest.MunicipalityRegister(request);

        // Assert
        Assertions.assertTrue(result);
        verify(officeRepository, times(1)).findByEmail("john.doe@example.com");
        verify(officeRepository, times(1)).saveOffice(any(Office.class));
    }

    @Test
    void testMunicipalityRegister_WithExistingEmail_ShouldThrowEmailExistException() {
        // Arrange
        MunicipalityRegistrationRequest request = new MunicipalityRegistrationRequest();
        request.setContact("Jane Smith");
        request.setEmail("jane.smith@example.com");

        when(officeRepository.findByEmail(anyString())).thenReturn(Optional.of(new Office()));

        // Act and Assert
        Assertions.assertThrows(EmailExistException.class, () -> underTest.MunicipalityRegister(request));
        verify(officeRepository, times(1)).findByEmail("jane.smith@example.com");
        verify(officeRepository, never()).saveOffice(any(Office.class));
    }
}