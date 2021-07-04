package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void addDriver(DriverDTO dto);
    void updateDrive(DriverDTO dto);
    void deleteDriver(String id);
    List<DriverDTO> getAllDrivers();
    DriverDTO searchDriver(String id);
}
