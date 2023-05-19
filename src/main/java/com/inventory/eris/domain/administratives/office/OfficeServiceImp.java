package com.inventory.eris.domain.administratives.office;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfficeServiceImp implements OfficeService {

    private final OfficeDao officeDao;

    public List<Office> allOffices() {
        return officeDao.allOffice();
    }

    public Optional<Office> selectOffice(Long id) {
        return officeDao.selectoffice(id);
    }

}
