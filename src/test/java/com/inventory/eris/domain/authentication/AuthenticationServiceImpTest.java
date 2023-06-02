package com.inventory.eris.domain.authentication;

import com.inventory.eris.utils.Exception.EmailExistException;
import com.inventory.eris.domain.administratives.Personnel.Personnel;
import com.inventory.eris.domain.administratives.Personnel.PersonnelDao;
import com.inventory.eris.domain.administratives.assignoffice.AssignOffice;
import com.inventory.eris.domain.administratives.assignoffice.AssignOfficeDao;
import com.inventory.eris.domain.administratives.municipality.Municipality;
import com.inventory.eris.domain.administratives.municipality.MunicipalityDao;
import com.inventory.eris.domain.administratives.office.Office;
import com.inventory.eris.domain.administratives.office.OfficeDao;
import com.inventory.eris.domain.administratives.role.Role;
import com.inventory.eris.domain.administratives.role.RoleDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


class AuthenticationServiceImpTest {

    @Mock
    private OfficeDao officeDao;
    @Mock
    private AssignOfficeDao assignOfficeDao;
    @Mock
    private MunicipalityDao municipalityDao;
    @Mock
    private PersonnelDao personnelDao;
    @Mock
    private RoleDao roleDao;
    @Mock
    private PasswordEncoder passwordEncoder;

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

        when(officeDao.findByEmail(anyString())).thenReturn(Optional.empty());

        Optional<AssignOffice> emptyAssignOffice = Optional.empty();
        when(assignOfficeDao.selectAssignByMunicipalityId(request.getMunicipality())).thenReturn(emptyAssignOffice);

        Municipality municipality = new Municipality();
        when(municipalityDao.selectMunicipality(request.getMunicipality())).thenReturn(Optional.of(municipality));

        AssignOffice assigningOffice = new AssignOffice();
        when(assignOfficeDao.saveAssign(any(AssignOffice.class))).thenReturn(assigningOffice);

        Personnel personnel = new Personnel();
        when(personnelDao.savePersonnel(any(Personnel.class))).thenReturn(personnel);

        Role role = new Role();
        when(roleDao.findByRoleType(anyString())).thenReturn(Optional.of(role));

        Office office = new Office();
        when(officeDao.saveOffice(any(Office.class))).thenReturn(office);

        // Act
        underTest.MunicipalityRegister(request);





        // Assert
      
        verify(officeDao, times(1)).findByEmail(request.getEmail());
        verify(assignOfficeDao, times(1)).selectAssignByMunicipalityId(request.getMunicipality());
        verify(municipalityDao, times(1)).selectMunicipality(request.getMunicipality());
        verify(assignOfficeDao, times(1)).saveAssign(any(AssignOffice.class));
        verify(personnelDao, times(1)).savePersonnel(any(Personnel.class));
        verify(roleDao, times(1)).findByRoleType(anyString());
        verify(officeDao, times(1)).saveOffice(any(Office.class));
    }

    @Test
    void testMunicipalityRegister_WithExistingEmail_ShouldThrowEmailExistException() {
        // Arrange
        MunicipalityRegistrationRequest request = new MunicipalityRegistrationRequest();
        request.setContact("Jane Smith");
        request.setEmail("jane.smith@example.com");

        when(officeDao.findByEmail(anyString())).thenReturn(Optional.of(new Office()));

        // Act and Assert
        Assertions.assertThrows(EmailExistException.class, () -> underTest.MunicipalityRegister(request));
        verify(officeDao, times(1)).findByEmail("jane.smith@example.com");
        verify(officeDao, never()).saveOffice(any(Office.class));
    }
}