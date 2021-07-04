package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public void addCar(CarDTO dto) {
        if (!carRepo.existsById(dto.getCarRegNo())) {
            carRepo.save(modelMapper.map(dto, Car.class));
        } else {
            throw new ValidateException(dto.getCarRegNo()+" Car is already Exist in this Database");
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (carRepo.existsById(dto.getCarRegNo())) {
            carRepo.save(modelMapper.map(dto, Car.class));
        } else {
            throw new ValidateException(dto.getCarRegNo()+" <- This car Not Found for update in this database");
        }
    }

    @Override
    public void deleteCar(String id) {
        if (carRepo.existsById(id)) {
            carRepo.deleteById(id);
        } else {
            throw new ValidateException(id+" <- This car cant delete in this database");
        }
    }

    @Override
    public List<CarDTO> getAllCar() {
        return modelMapper.map(carRepo.findAll(), new TypeToken<List<CarDTO>>(){}.getType());
    }

    @Override
    public CarDTO searchCar(String id) {
        Optional<Car> car = carRepo.findById(id);
        if (car.isPresent()) {
            return modelMapper.map(car.get(), CarDTO.class);
        } else {
            throw new ValidateException(id+" <- This car Not Found in this database");
        }
    }
}
