package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addDriver(DriverDTO dto) {
        if (!driverRepo.existsById(dto.getDriverId())) {
            driverRepo.save(modelMapper.map(dto, Driver.class));
        } else {
            throw new ValidateException(dto.getDriverId()+" Driver is already Exist in this Database");
        }
    }

    @Override
    public void updateDrive(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDriverId())) {
            driverRepo.save(modelMapper.map(dto, Driver.class));
        } else {
            throw new ValidateException(dto.getDriverId()+" <- This Driver Not Found for update in this database");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (driverRepo.existsById(id)) {
            driverRepo.deleteById(id);
        } else {
            throw new ValidateException(id+" <- This driver cant delete in this database");
        }
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return modelMapper.map(driverRepo.findAll(), new TypeToken<List<DriverDTO>>(){}.getType());
    }

    @Override
    public DriverDTO searchDriver(String id) {
        Optional<Driver> driver = driverRepo.findById(id);
        if (driver.isPresent()) {
            return modelMapper.map(driver.get(), DriverDTO.class);
        } else {
            throw new ValidateException(id+" <- This Driver Not Found in this database");
        }
    }
}
