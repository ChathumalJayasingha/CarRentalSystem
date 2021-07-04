package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;

import java.util.List;

public interface CarService {
    void addCar(CarDTO dto);
    void updateCar(CarDTO dto);
    void deleteCar(String id);
    List<CarDTO> getAllCar();
    CarDTO searchCar(String id);
}
