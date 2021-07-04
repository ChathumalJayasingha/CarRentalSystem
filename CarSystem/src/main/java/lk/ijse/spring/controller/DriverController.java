package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    private DriverService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveDriver(@RequestBody DriverDTO dto) {
        if (dto.getDriverId().trim().length() <= 0) {
            throw new NotFoundException("Driver NIC cannot be empty");
        }
        if (dto.getDriverName().trim().length() <= 0) {
            throw new NotFoundException("Driver name cannot be empty");
        }
        if (dto.getDriverAddress().trim().length() <= 0) {
            throw new NotFoundException("Driver address cannot be empty");
        }
        if (dto.getDriverContact().trim().length() <= 0) {
            throw new NotFoundException("Driver contact cannot be empty");
        }
        service.addDriver(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllDrivers() {
        List<DriverDTO> allDrivers = service.getAllDrivers();
        return new ResponseEntity(new StandardResponse("200", "Done", allDrivers), HttpStatus.OK);
    }

    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchDriver(@RequestParam String id) {
        DriverDTO driverDTO = service.searchDriver(id);
        return new ResponseEntity(new StandardResponse("200", "Done", driverDTO), HttpStatus.OK);
    }


    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteDriver(@RequestParam String id) {
        service.deleteDriver(id);
        return new ResponseEntity(new StandardResponse("200", "Done", id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDriver(@RequestBody DriverDTO dto) {
        if (dto.getDriverId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        service.updateDrive(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

}
