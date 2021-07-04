package lk.ijse.spring.controller;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.service.UserService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDTO dto) {
        if (dto.getUserId().trim().length() <= 0) {
            throw new NotFoundException("User NIC cannot be empty");
        }
        if (dto.getUserEmail().trim().length() <= 0) {
            throw new NotFoundException("User email cannot be empty");
        }
        if (dto.getUserPassword().trim().length() <= 0) {
            throw new NotFoundException("User password cannot be empty");
        }
        if (dto.getUserRole().trim().length() <= 0) {
            throw new NotFoundException("User role cannot be empty");
        }
        service.addUser(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCustomers() {
        List<UserDTO> allUsers = service.getAllUsers();
        return new ResponseEntity(new StandardResponse("200", "Done", allUsers), HttpStatus.OK);
    }

    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchUser(@RequestParam String id) {
        UserDTO userDTO = service.searchUser(id);
        return new ResponseEntity(new StandardResponse("200", "Done", userDTO), HttpStatus.OK);
    }
//            path = "/{id}

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity UserCustomer(@RequestParam String id) {
        service.deleteUser(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody UserDTO dto) {
        if (dto.getUserId().trim().length() <= 0) {
            throw new NotFoundException("No user id provided to update");
        }
        service.updateUser(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

}
