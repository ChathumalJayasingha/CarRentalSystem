package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ReturnDTO;
import lk.ijse.spring.service.ReturnService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/returns")
public class ReturnsController {

    @Autowired
    private ReturnService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveOrderReturn(@RequestBody ReturnDTO dto) {
        service.addReturn(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }


    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchReturns(@RequestParam String id) {
        ReturnDTO returnDTO = service.searchReturn(id);
        return new ResponseEntity(new StandardResponse("200", "Done", returnDTO), HttpStatus.OK);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllReturns() {
        List<ReturnDTO> allReturns = service.getAllReturns();
        return new ResponseEntity(new StandardResponse("200", "Done", allReturns), HttpStatus.OK);
    }



}
