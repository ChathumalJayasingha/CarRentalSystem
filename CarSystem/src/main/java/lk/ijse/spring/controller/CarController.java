package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.service.FileSystemService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService service;

    @Autowired
    FileSystemService fileSystemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCar(@RequestBody CarDTO dto) {
        if (dto.getCarRegNo().trim().length() <= 0) {
            throw new NotFoundException("ReNo cannot be empty");
        }
        if (dto.getCarColor().trim().length() <= 0) {
            throw new NotFoundException("car colr cannot be empty");
        }
        if (dto.getCarBrand().trim().length() <= 0) {
            throw new NotFoundException("Car brand cannot be empty");
        }
        if (dto.getCarType().trim().length()  <= 0) {
            throw new NotFoundException("Car type  cannot be empty");
        }
        if (dto.getCarFuelType().trim().length()  <= 0) {
            throw new NotFoundException("Car fuel type  cannot be empty");
        }
        if (dto.getCarTransmission().trim().length()  <= 0) {
            throw new NotFoundException("Car Transmission  cannot be empty");
        }



        service.addCar(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCars() {
        List<CarDTO> allCar = service.getAllCar();
        return new ResponseEntity(new StandardResponse("200", "Done", allCar), HttpStatus.OK);
    }

    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCar(@RequestParam String id) {
        CarDTO carDTO = service.searchCar(id);
        return new ResponseEntity(new StandardResponse("200", "Done", carDTO), HttpStatus.OK);
    }


    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCar(@RequestParam String id) {
        service.deleteCar(id);
        return new ResponseEntity(new StandardResponse("200", "Done", id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCar(@RequestBody CarDTO dto) {
        if (dto.getCarRegNo().trim().length() <= 0) {
            throw new NotFoundException("No carRegNo provided to update");
        }
        service.updateCar(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

}
